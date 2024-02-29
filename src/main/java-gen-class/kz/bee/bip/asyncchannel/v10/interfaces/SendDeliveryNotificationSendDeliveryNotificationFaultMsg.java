
package kz.bee.bip.asyncchannel.v10.interfaces;

import jakarta.xml.ws.WebFault;


/**
 * Ошибка
 *
 * This class was generated by Apache CXF 4.0.3
 * 2024-02-28T17:57:49.937+06:00
 * Generated source version: 4.0.3
 */

@WebFault(name = "sendDeliveryNotificationFault1_sendDeliveryNotificationFault", targetNamespace = "http://bip.bee.kz/AsyncChannel/v10/Types")
public class SendDeliveryNotificationSendDeliveryNotificationFaultMsg extends Exception {
    public static final long serialVersionUID = 1L;

    private kz.bee.bip.common.v10.types.ErrorInfo faultInfo;

    public SendDeliveryNotificationSendDeliveryNotificationFaultMsg() {
        super();
    }

    public SendDeliveryNotificationSendDeliveryNotificationFaultMsg(String message) {
        super(message);
    }

    public SendDeliveryNotificationSendDeliveryNotificationFaultMsg(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public SendDeliveryNotificationSendDeliveryNotificationFaultMsg(String message, kz.bee.bip.common.v10.types.ErrorInfo sendDeliveryNotificationFault1SendDeliveryNotificationFault) {
        super(message);
        this.faultInfo = sendDeliveryNotificationFault1SendDeliveryNotificationFault;
    }

    public SendDeliveryNotificationSendDeliveryNotificationFaultMsg(String message, kz.bee.bip.common.v10.types.ErrorInfo sendDeliveryNotificationFault1SendDeliveryNotificationFault, java.lang.Throwable cause) {
        super(message, cause);
        this.faultInfo = sendDeliveryNotificationFault1SendDeliveryNotificationFault;
    }

    public kz.bee.bip.common.v10.types.ErrorInfo getFaultInfo() {
        return this.faultInfo;
    }
}
