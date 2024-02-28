package kz.esb.kafka;

import org.apache.camel.component.kafka.KafkaComponent;
import org.apache.camel.component.kafka.KafkaConfiguration;
import org.apache.camel.component.kafka.KafkaConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("kafka")
public class EsbKafkaComponent extends KafkaComponent {

    public EsbKafkaComponent(@Value("${camel.component.kafka.brokers}") String brokers) {
        var configuration = new KafkaConfiguration();
        configuration.setBrokers(brokers);
        configuration.setAutoCommitEnable(false);
        configuration.setAllowManualCommit(true);
        configuration.setBreakOnFirstError(true);
        configuration.setMaxPartitionFetchBytes(52428800);
        configuration.setAutoOffsetReset("earliest");
        configuration.setPartitionKey(0);
        configuration.setKey("1");
        setConfiguration(configuration);
    }
}
