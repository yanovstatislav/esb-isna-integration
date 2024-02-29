
package kz.bee.bip.syncchannel.v10.interfaces;

import jakarta.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 4.0.3
 * 2024-02-28T17:57:50.075+06:00
 * Generated source version: 4.0.3
 */

@WebFault(name = "SendMessageFault1_SendMessageFault", targetNamespace = "http://bip.bee.kz/SyncChannel/v10/Types")
public class SendMessageSendMessageFaultMsg extends Exception {
    public static final long serialVersionUID = 1L;

    private kz.bee.bip.common.v10.types.ErrorInfo faultInfo;

    public SendMessageSendMessageFaultMsg() {
        super();
    }

    public SendMessageSendMessageFaultMsg(String message) {
        super(message);
    }

    public SendMessageSendMessageFaultMsg(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public SendMessageSendMessageFaultMsg(String message, kz.bee.bip.common.v10.types.ErrorInfo sendMessageFault1SendMessageFault) {
        super(message);
        this.faultInfo = sendMessageFault1SendMessageFault;
    }

    public SendMessageSendMessageFaultMsg(String message, kz.bee.bip.common.v10.types.ErrorInfo sendMessageFault1SendMessageFault, java.lang.Throwable cause) {
        super(message, cause);
        this.faultInfo = sendMessageFault1SendMessageFault;
    }

    public kz.bee.bip.common.v10.types.ErrorInfo getFaultInfo() {
        return this.faultInfo;
    }
}
