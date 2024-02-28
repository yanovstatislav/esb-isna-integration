package kz.esb.kafka;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.kafka.KafkaConstants;
import org.apache.camel.component.kafka.consumer.KafkaManualCommit;

public class KafkaManualCommitProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        var manual = exchange.getIn().getHeader(KafkaConstants.MANUAL_COMMIT, KafkaManualCommit.class);
        if (manual != null) manual.commit();
    }
}
