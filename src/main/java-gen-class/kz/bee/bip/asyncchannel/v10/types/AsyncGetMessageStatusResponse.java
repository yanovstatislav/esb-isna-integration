
package kz.bee.bip.asyncchannel.v10.types;

import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import kz.bee.bip.common.v10.types.MessageState;
import kz.bee.bip.common.v10.types.MessageStatusInfo;


/**
 * <p>Java class for AsyncGetMessageStatusResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AsyncGetMessageStatusResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="messageState" type="{http://bip.bee.kz/common/v10/types}MessageState"/&gt;
 *         &lt;element name="status" type="{http://bip.bee.kz/common/v10/types}MessageStatusInfo"/&gt;
 *         &lt;element name="responseDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="sessionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AsyncGetMessageStatusResponse", propOrder = {
    "messageState",
    "status",
    "responseDate",
    "sessionId"
})
public class AsyncGetMessageStatusResponse {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected MessageState messageState;
    @XmlElement(required = true)
    protected MessageStatusInfo status;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar responseDate;
    protected String sessionId;

    /**
     * Gets the value of the messageState property.
     * 
     * @return
     *     possible object is
     *     {@link MessageState }
     *     
     */
    public MessageState getMessageState() {
        return messageState;
    }

    /**
     * Sets the value of the messageState property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageState }
     *     
     */
    public void setMessageState(MessageState value) {
        this.messageState = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link MessageStatusInfo }
     *     
     */
    public MessageStatusInfo getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageStatusInfo }
     *     
     */
    public void setStatus(MessageStatusInfo value) {
        this.status = value;
    }

    /**
     * Gets the value of the responseDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getResponseDate() {
        return responseDate;
    }

    /**
     * Sets the value of the responseDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setResponseDate(XMLGregorianCalendar value) {
        this.responseDate = value;
    }

    /**
     * Gets the value of the sessionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * Sets the value of the sessionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSessionId(String value) {
        this.sessionId = value;
    }

}
