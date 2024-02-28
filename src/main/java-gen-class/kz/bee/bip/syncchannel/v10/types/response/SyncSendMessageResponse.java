
package kz.bee.bip.syncchannel.v10.types.response;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import kz.bee.bip.common.v10.types.MessageData;
import kz.bee.bip.syncchannel.v10.types.SyncMessageInfoResponse;


/**
 * информация о сообщении ответе
 * 
 * <p>Java class for SyncSendMessageResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SyncSendMessageResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="responseInfo" type="{http://bip.bee.kz/SyncChannel/v10/types}SyncMessageInfoResponse"/&gt;
 *         &lt;element name="responseData" type="{http://bip.bee.kz/common/v10/types}MessageData"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SyncSendMessageResponse", propOrder = {
    "responseInfo",
    "responseData"
})
public class SyncSendMessageResponse {

    @XmlElement(required = true)
    protected SyncMessageInfoResponse responseInfo;
    @XmlElement(required = true)
    protected MessageData responseData;

    /**
     * Gets the value of the responseInfo property.
     * 
     * @return
     *     possible object is
     *     {@link SyncMessageInfoResponse }
     *     
     */
    public SyncMessageInfoResponse getResponseInfo() {
        return responseInfo;
    }

    /**
     * Sets the value of the responseInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link SyncMessageInfoResponse }
     *     
     */
    public void setResponseInfo(SyncMessageInfoResponse value) {
        this.responseInfo = value;
    }

    /**
     * Gets the value of the responseData property.
     * 
     * @return
     *     possible object is
     *     {@link MessageData }
     *     
     */
    public MessageData getResponseData() {
        return responseData;
    }

    /**
     * Sets the value of the responseData property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageData }
     *     
     */
    public void setResponseData(MessageData value) {
        this.responseData = value;
    }

}
