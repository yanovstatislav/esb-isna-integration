package kz.esb.route;

import kz.esb.kafka.CamelHeadersFilterStrategy;
import kz.esb.kafka.KafkaHeaderDeserializerProcessor;
import kz.esb.kafka.KafkaManualCommitProcessor;
import kz.esb.processor.OutcomeProcessor;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.http.base.HttpOperationFailedException;
import org.springframework.stereotype.Component;

@Component
public class OutcomeRouteBuilder extends RouteBuilder {

    public OutcomeRouteBuilder() {
    }

    @Override
    public void configure() {

        getContext().getRegistry().bind("kafkaCommit", new KafkaManualCommitProcessor());
        getContext().getRegistry().bind("httpCallFilterStrategy", new CamelHeadersFilterStrategy());

        onException(kz.esb.exception.EsbException.class)
                .onException(Throwable.class)
                .handled(true)
                .process(exchange -> {
                    final HttpOperationFailedException e = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, HttpOperationFailedException.class);

                    if (e != null) {
                        exchange.setProperty("responseBody", e.getResponseBody());
                    }
                })
//                .log("STACKTRACE ---- ${exception.stacktrace}")
//                .log("EXCEPTION ---- ${exception.message}")
                .to("kafka:DEAD_MESSAGE")
                .process("kafkaCommit");

        from("kafka:IN_BT*&topicIsPattern=true")//&
//        from("kafka:IN_BT_PEP_INIS_READNOTIFICATION")
                .routeId("deliverMessage")
                .process(new KafkaHeaderDeserializerProcessor())
                .setHeader("requestXML", simple("${in.body}"))
                .process(new OutcomeProcessor())
                .setHeader("Content-Type", constant("text/xml;charset=UTF-8"))
                .setHeader("SOAPAction", constant(""))
                .setHeader(Exchange.HTTP_METHOD, constant("POST"))
                .setHeader(Exchange.HTTP_CHUNKED, constant(false))
                .toD("http4://dummyhost&headerFilterStrategy=#httpCallFilterStrategy&responseTimeout=5000")
                .convertBodyTo(String.class)
                .process("kafkaCommit");

    }

}
