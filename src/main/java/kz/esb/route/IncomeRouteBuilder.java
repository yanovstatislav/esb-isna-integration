package kz.esb.route;

import kz.bee.bip.asyncchannel.v10.interfaces.IAsyncChannel;
import kz.esb.consts.EsbMessageTypeConsts;
import kz.esb.processor.AsyncCreateAcknowledgement;
import kz.esb.processor.IncomeQualifierProcessor;
import org.apache.camel.ExchangePropertyKey;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.cxf.common.DataFormat;
import org.apache.camel.component.cxf.jaxws.CxfEndpoint;
import org.apache.camel.component.kafka.KafkaConstants;
import org.apache.cxf.binding.soap.SoapFault;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class IncomeRouteBuilder extends RouteBuilder {

    public IncomeRouteBuilder() {
    }

    @Bean
    CxfEndpoint asyncChannel() {
        var asyncChannelEndpoint = new CxfEndpoint();
        asyncChannelEndpoint.setWsdlURL("wsdl/AsyncChannel/v10/Interfaces/AsyncChannelHttp_Service.wsdl");
        asyncChannelEndpoint.setServiceClass(IAsyncChannel.class);
        asyncChannelEndpoint.setAddress("/asyncChannel");
        asyncChannelEndpoint.setDataFormat(DataFormat.POJO);
        asyncChannelEndpoint.setProperties(new HashMap<>());
        asyncChannelEndpoint.getProperties().put("schema-validation-enabled", "false");
        return asyncChannelEndpoint;
    }

    @Override
    public void configure() {

        onException(SoapFault.class)
                .maximumRedeliveries(0)
                .handled(true)
                .process(exchange -> {
                    SoapFault fault = exchange.getProperty(ExchangePropertyKey.EXCEPTION_CAUGHT, SoapFault.class);
                    exchange.getMessage().setBody(fault);
                })
                .end();

        from("cxf:bean:asyncChannel")
                .routeId("async-kafka")
                .process(new IncomeQualifierProcessor())
                .setHeader("MessageType", constant(EsbMessageTypeConsts.ASYNC_CHANNEL))
                .setHeader(KafkaConstants.OVERRIDE_TOPIC, simple("IN_${header.ShepServiceId}"))
                .setHeader(KafkaConstants.PARTITION_KEY, simple("0"))
                .setHeader(KafkaConstants.KEY, simple("1"))
                .to("kafka:myTopic")
                .process(new AsyncCreateAcknowledgement())
                .end();

    }

}
