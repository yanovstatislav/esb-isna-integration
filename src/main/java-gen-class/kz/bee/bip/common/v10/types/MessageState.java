
package kz.bee.bip.common.v10.types;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MessageState.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="MessageState"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="ON_DELIVERY"/&gt;
 *     &lt;enumeration value="DELIVERED"/&gt;
 *     &lt;enumeration value="NOT_DELIVERED"/&gt;
 *     &lt;enumeration value="DELIVERY_STOPPED"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "MessageState")
@XmlEnum
public enum MessageState {

    ON_DELIVERY,
    DELIVERED,
    NOT_DELIVERED,
    DELIVERY_STOPPED;

    public String value() {
        return name();
    }

    public static MessageState fromValue(String v) {
        return valueOf(v);
    }

}
