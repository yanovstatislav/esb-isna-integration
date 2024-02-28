
package kz.bee.bip.asyncchannel.v10.interfaces;

import jakarta.xml.ws.WebFault;


/**
 * Ошибка
 *
 * This class was generated by Apache CXF 4.0.3
 * 2024-02-28T14:28:52.432+06:00
 * Generated source version: 4.0.3
 */

@WebFault(name = "sendMessageFault1_sendMessageFault", targetNamespace = "http://bip.bee.kz/AsyncChannel/v10/Types")
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