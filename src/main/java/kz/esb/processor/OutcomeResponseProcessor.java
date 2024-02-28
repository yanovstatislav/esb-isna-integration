package kz.esb.processor;

import kz.esb.consts.EsbHeaderConsts;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.cxf.common.util.StringUtils;
import kz.esb.utils.MessageHelper;

public class OutcomeResponseProcessor implements Processor {

    @Override
    public void process(Exchange exchange) {
        var response = exchange.getIn().getHeader(EsbHeaderConsts.RESPONSE_XML, String.class);
        if (response == null || StringUtils.isEmpty(response.trim())) {
            return;
        }

    }

}
