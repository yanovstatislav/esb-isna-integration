package kz.esb.processor;

import kz.bee.bip.asyncchannel.v10.types.AsyncSendMessageResponse;
import kz.esb.consts.EsbHeaderConsts;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import javax.xml.datatype.DatatypeFactory;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class AsyncCreateAcknowledgement implements Processor {

    private static final TimeZone TIME_ZONE = TimeZone.getTimeZone("GMT+5");

    @Override
    public void process(Exchange exchange) throws Exception {
        var asyncSendMessageResponse = new AsyncSendMessageResponse();
        asyncSendMessageResponse.setCorrelationId(exchange.getIn().getHeader(EsbHeaderConsts.SHEP_CORRELATION_ID, String.class));
        asyncSendMessageResponse.setMessageId(exchange.getIn().getHeader(EsbHeaderConsts.SHEP_MESSAGE_ID, String.class));
        asyncSendMessageResponse.setSessionId(exchange.getIn().getHeader(EsbHeaderConsts.SHEP_SESSION_ID, String.class));
        asyncSendMessageResponse.setResponseDate(DatatypeFactory.newInstance().newXMLGregorianCalendar((GregorianCalendar) Calendar.getInstance(TIME_ZONE)));
        exchange.getIn().setBody(asyncSendMessageResponse);
    }

}