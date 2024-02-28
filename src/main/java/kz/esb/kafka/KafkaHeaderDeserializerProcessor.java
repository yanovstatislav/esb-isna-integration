package kz.esb.kafka;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import java.nio.charset.StandardCharsets;

public class KafkaHeaderDeserializerProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        var headers = exchange.getIn().getHeaders();
        if (headers == null) {
            return;
        }

        for (var header : headers.entrySet()) {
            if (header.getValue() == null || !(header.getValue() instanceof byte[])) {
                exchange.getIn().setHeader(header.getKey(), header.getValue());
                continue;
            }

            var headerName = header.getKey();
            var bytes = (byte[]) header.getValue();
            exchange.getIn().setHeader(headerName, new String(bytes, StandardCharsets.UTF_8));

        }
    }
}
