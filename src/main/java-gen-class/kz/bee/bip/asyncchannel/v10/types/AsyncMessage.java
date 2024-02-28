
package kz.bee.bip.asyncchannel.v10.types;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import kz.bee.bip.common.v10.types.MessageData;


/**
 * <p>Java class for AsyncMessage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AsyncMessage"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="messageInfo" type="{http://bip.bee.kz/AsyncChannel/v10/types}AsyncMessageInfo"/&gt;
 *         &lt;element name="messageData" type="{http://bip.bee.kz/common/v10/types}MessageData"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AsyncMessage", propOrder = {
    "messageInfo",
    "messageData"
})
public class AsyncMessage {

    @XmlElement(required = true)
    protected AsyncMessageInfo messageInfo;
    @XmlElement(required = true)
    protected MessageData messageData;

    /**
     * Gets the value of the messageInfo property.
     * 
     * @return
     *     possible object is
     *     {@link AsyncMessageInfo }
     *     
     */
    public AsyncMessageInfo getMessageInfo() {
        return messageInfo;
    }

    /**
     * Sets the value of the messageInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link AsyncMessageInfo }
     *     
     */
    public void setMessageInfo(AsyncMessageInfo value) {
        this.messageInfo = value;
    }

    /**
     * Gets the value of the messageData property.
     * 
     * @return
     *     possible object is
     *     {@link MessageData }
     *     
     */
    public MessageData getMessageData() {
        return messageData;
    }

    /**
     * Sets the value of the messageData property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageData }
     *     
     */
    public void setMessageData(MessageData value) {
        this.messageData = value;
    }

}
