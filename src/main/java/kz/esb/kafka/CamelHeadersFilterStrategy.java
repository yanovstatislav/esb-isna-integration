package kz.esb.kafka;

import kz.esb.consts.EsbHeaderConsts;
import org.apache.camel.Exchange;
import org.apache.camel.spi.HeaderFilterStrategy;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CamelHeadersFilterStrategy implements HeaderFilterStrategy {

    private static final String CAMEL = "Camel";
    private static final String SHEP = "Shep";

    @Override
    public boolean applyFilterToCamelHeaders(String headerName, Object headerValue, Exchange exchange) {
        return headerName.startsWith(CAMEL) || headerName.startsWith(SHEP) || EsbHeaderConsts.REQUEST_XML.equals(headerName);
    }

    @Override
    public boolean applyFilterToExternalHeaders(String headerName, Object headerValue, Exchange exchange) {
        return headerName.startsWith(CAMEL) || headerName.startsWith(SHEP) || EsbHeaderConsts.REQUEST_XML.equals(headerName);
    }
}
