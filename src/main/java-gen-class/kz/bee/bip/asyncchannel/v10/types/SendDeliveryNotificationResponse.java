
package kz.bee.bip.asyncchannel.v10.types;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="response" type="{http://bip.bee.kz/AsyncChannel/v10/types}AsyncSendDeliveryNotificationResponse"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "response"
})
@XmlRootElement(name = "sendDeliveryNotificationResponse", namespace = "http://bip.bee.kz/AsyncChannel/v10/Types")
public class SendDeliveryNotificationResponse {

    @XmlElement(required = true, nillable = true)
    protected AsyncSendDeliveryNotificationResponse response;

    /**
     * Gets the value of the response property.
     * 
     * @return
     *     possible object is
     *     {@link AsyncSendDeliveryNotificationResponse }
     *     
     */
    public AsyncSendDeliveryNotificationResponse getResponse() {
        return response;
    }

    /**
     * Sets the value of the response property.
     * 
     * @param value
     *     allowed object is
     *     {@link AsyncSendDeliveryNotificationResponse }
     *     
     */
    public void setResponse(AsyncSendDeliveryNotificationResponse value) {
        this.response = value;
    }

}
