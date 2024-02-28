package kz.esb.processor;

import kz.esb.consts.EsbHeaderConsts;
import kz.esb.utils.MessageHelper;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.kafka.KafkaConstants;

public class OutcomeProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        var businessXML = exchange.getIn().getBody(String.class);

        var serviceId = exchange.getIn().getHeader(EsbHeaderConsts.SHEP_SERVICE_ID, String.class);
        var qualifier = exchange.getIn().getHeader(EsbHeaderConsts.QUALIFIER, String.class).toLowerCase();
        var messageId = exchange.getIn().getHeader(EsbHeaderConsts.SHEP_MESSAGE_ID, String.class);
        var shepCorrelationId =  exchange.getIn().getHeader(EsbHeaderConsts.SHEP_CORRELATION_ID, String.class);

        businessXML = "<data>" + businessXML + "</data>";

        var envXml = "";
        if (qualifier.equalsIgnoreCase("RESPONSE") ||
                qualifier.equalsIgnoreCase("NOTIFICATION") ||
                qualifier.equalsIgnoreCase("UPDATE")) {
            envXml = MessageHelper.createResponse(businessXML, serviceId, qualifier.toUpperCase(), messageId, shepCorrelationId);
        } else {
            envXml = MessageHelper.createSoapRequest(businessXML, serviceId, qualifier.toUpperCase());
        }

        exchange.getIn().setHeader(KafkaConstants.MANUAL_COMMIT, exchange.getIn().getHeader(KafkaConstants.MANUAL_COMMIT));
        exchange.getIn().setHeader(Exchange.HTTP_URI, qualifier.equals("request") ? "{{outcome.url.receiver}}" : "{{outcome.url.response}}");

        exchange.getIn().setBody(envXml);

    }


}
