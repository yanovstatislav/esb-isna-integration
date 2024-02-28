package kz.esb.processor;

import kz.bee.bip.asyncchannel.v10.types.AsyncSendMessageRequest;
import kz.esb.consts.EsbHeaderConsts;
import kz.esb.consts.EsbMessageTypeConsts;
import kz.esb.utils.MessageHelper;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import static java.util.Objects.nonNull;

public class IncomeQualifierProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        exchange.setProperty(EsbHeaderConsts.MESSAGE_TYPE, EsbMessageTypeConsts.ASYNC_CHANNEL);
        var messageRequest = exchange.getIn().getBody(AsyncSendMessageRequest.class);

        if (messageRequest == null) {
            return;
        }

        if (messageRequest.getMessageData().getData() == null) {
            return;
        }
        if (messageRequest.getMessageInfo() != null) {
            if (nonNull(messageRequest.getMessageInfo().getMessageType())) {
                exchange.getIn().setHeader(EsbHeaderConsts.QUALIFIER, messageRequest.getMessageInfo().getMessageType());
            }
            if (nonNull(messageRequest.getMessageInfo().getMessageId())) {
                exchange.getIn().setHeader(EsbHeaderConsts.SHEP_MESSAGE_ID, messageRequest.getMessageInfo().getMessageId());
            }
            if (nonNull(messageRequest.getMessageInfo().getCorrelationId())) {
                exchange.getIn().setHeader(EsbHeaderConsts.SHEP_CORRELATION_ID, messageRequest.getMessageInfo().getCorrelationId());
            }
            if (nonNull(messageRequest.getMessageInfo().getServiceId())) {
                exchange.getIn().setHeader(EsbHeaderConsts.SHEP_SERVICE_ID, messageRequest.getMessageInfo().getServiceId());
            }
            if (messageRequest.getMessageInfo().getMessageDate() != null) {
                exchange.getIn().setHeader(EsbHeaderConsts.MESSAGE_DATE, messageRequest.getMessageInfo().getMessageDate());
            }
            if (nonNull(messageRequest.getMessageInfo().getSessionId())) {
                exchange.getIn().setHeader(EsbHeaderConsts.SHEP_SESSION_ID, messageRequest.getMessageInfo().getSessionId());
            }
        }

        exchange.getIn().setBody(MessageHelper.extractBody(messageRequest.getMessageData(), false));

    }


}
