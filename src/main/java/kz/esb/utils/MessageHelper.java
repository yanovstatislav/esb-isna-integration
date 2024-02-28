package kz.esb.utils;

import jakarta.xml.bind.JAXB;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import kz.esb.enums.EsbError;
import kz.esb.exception.EsbException;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.TimeZone;

public class MessageHelper {

    public static final TimeZone TIME_ZONE_GTM = TimeZone.getTimeZone("GMT+6");

    private MessageHelper() {
    }

    public static String toString(Object object) throws EsbException {
        var writer = new StringWriter();

        if (object != null) {
            try {
                var jaxbContext = JAXBContext.newInstance(object.getClass());
                var marshaller = jaxbContext.createMarshaller();
                marshaller.setProperty("jaxb.formatted.output", true);
                marshaller.marshal(object, writer);
            } catch (JAXBException e) {
                throw new EsbException(EsbError.SHEP_ASYNC_XML_INVALID);
            }
        }
        return writer.toString();
    }

    public static String serialize(Object obj) {
        StringWriter result = new StringWriter();
        JAXB.marshal(obj, result);
        return result.toString();
    }

    public static String extractBody(Object body, boolean isData) throws Exception {
        var builderFactory = DocumentBuilderFactory.newInstance();
        var builder = builderFactory.newDocumentBuilder();
        var doc = builder.parse(new ByteArrayInputStream(serialize(body).getBytes(StandardCharsets.UTF_8)));

        Element nodes;

        if (isData) {
            // nodes = doc.getElementsByTagName("data");
            XPath xPath = XPathFactory.newInstance().newXPath();
            nodes = (Element) xPath.compile("//*[local-name()='messageData']").evaluate(doc, XPathConstants.NODE);
          //  nodes = data.getChildNodes();
        } else {
            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();
            XPathExpression expr = xpath.compile("//*[local-name()='messageData']/child::*");
            nodes = (Element) expr.evaluate(doc, XPathConstants.NODE);
        }

        //  return nodeListToString(nodes);
        return convertElementToString(nodes);
    }

    public static String convertElementToString(Element element) throws Exception {
        DOMSource source = new DOMSource(element);
        StreamResult result = new StreamResult(new StringWriter());
        TransformerFactory.newInstance().newTransformer().transform(source, result);
        Writer writer = result.getWriter();
        Throwable var4 = null;

        String var5;
        try {
            var5 = writer.toString();
        } catch (Throwable var14) {
            var4 = var14;
            throw var14;
        } finally {
            if (writer != null) {
                if (var4 != null) {
                    try {
                        writer.close();
                    } catch (Throwable var13) {
                        var4.addSuppressed(var13);
                    }
                } else {
                    writer.close();
                }
            }

        }

        return var5;
    }

    public static String createResponse(String data, String routeId, String msgType, String messageId, String correlationId) {

        return "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<ns2:sendMessage xmlns:ns2=\"http://bip.bee.kz/AsyncChannel/v10/Types\">" +
                "<request>" +
                "<messageInfo>" +
                "<messageId>" + messageId + "</messageId>" +
                "<correlationId>" + correlationId + "</correlationId>" +
                "<serviceId>" + routeId + "</serviceId>" +
                "<messageType>" + msgType + "</messageType>" +
                "<messageDate>" + TimestampConverter.printDateTime(Calendar.getInstance(TIME_ZONE_GTM)) + "</messageDate>" +
                "<sender>" +
                "<senderId>******</senderId>" +
                "<password>******</password>" +
                "</sender>" +
                "</messageInfo>" +
                "<messageData>" + data +
                "</messageData>" +
                "</request>" +
                "</ns2:sendMessage>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";
    }

    public static String createSoapRequest(String data, String routeId, String msgType) {
        return "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<ns2:sendMessage xmlns:ns2=\"http://bip.bee.kz/AsyncChannel/v10/Types\">" +
                "<request>" +
                "<messageInfo>" +
                "<serviceId>" + routeId + "</serviceId>" +
                "<messageType>" + msgType + "</messageType>" +
                "<messageDate>" + TimestampConverter.printDateTime(Calendar.getInstance(TIME_ZONE_GTM)) + "</messageDate>" +
                "<sender>" +
                "<senderId>******</senderId>" +
                "<password>******</password>" +
                "</sender>" +
                "</messageInfo>" +
                "<messageData>" + data +
                "</messageData>" +
                "</request>" +
                "</ns2:sendMessage>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";
    }
}
