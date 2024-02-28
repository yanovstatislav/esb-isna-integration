
package kz.bee.bip.syncchannel.v10.types.request;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import kz.bee.bip.common.v10.types.MessageData;
import kz.bee.bip.syncchannel.v10.types.SyncMessageInfo;


/**
 * Формат объекта запроса метода отправки сообщения по синхронному каналу
 * 
 * <p>Java class for SyncSendMessageRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SyncSendMessageRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="requestInfo" type="{http://bip.bee.kz/SyncChannel/v10/types}SyncMessageInfo"/&gt;
 *         &lt;element name="requestData" type="{http://bip.bee.kz/common/v10/types}MessageData"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SyncSendMessageRequest", propOrder = {
    "requestInfo",
    "requestData"
})
public class SyncSendMessageRequest {

    @XmlElement(required = true)
    protected SyncMessageInfo requestInfo;
    @XmlElement(required = true)
    protected MessageData requestData;

    /**
     * Gets the value of the requestInfo property.
     * 
     * @return
     *     possible object is
     *     {@link SyncMessageInfo }
     *     
     */
    public SyncMessageInfo getRequestInfo() {
        return requestInfo;
    }

    /**
     * Sets the value of the requestInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link SyncMessageInfo }
     *     
     */
    public void setRequestInfo(SyncMessageInfo value) {
        this.requestInfo = value;
    }

    /**
     * Gets the value of the requestData property.
     * 
     * @return
     *     possible object is
     *     {@link MessageData }
     *     
     */
    public MessageData getRequestData() {
        return requestData;
    }

    /**
     * Sets the value of the requestData property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageData }
     *     
     */
    public void setRequestData(MessageData value) {
        this.requestData = value;
    }

}
