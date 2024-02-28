
package kz.bee.bip.common.v10.types;

import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ErrorInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ErrorInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="errorCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="errorMessage" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="errorData" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="errorDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="subError" type="{http://bip.bee.kz/common/v10/types}ErrorInfo" minOccurs="0"/&gt;
 *         &lt;element name="sessionId" type="{http://bip.bee.kz/common/v10/types}guid" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ErrorInfo", propOrder = {
    "errorCode",
    "errorMessage",
    "errorData",
    "errorDate",
    "subError",
    "sessionId"
})
public class ErrorInfo {

    @XmlElement(required = true)
    protected String errorCode;
    @XmlElement(required = true)
    protected String errorMessage;
    protected String errorData;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar errorDate;
    protected ErrorInfo subError;
    protected String sessionId;

    /**
     * Gets the value of the errorCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * Sets the value of the errorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorCode(String value) {
        this.errorCode = value;
    }

    /**
     * Gets the value of the errorMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets the value of the errorMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorMessage(String value) {
        this.errorMessage = value;
    }

    /**
     * Gets the value of the errorData property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorData() {
        return errorData;
    }

    /**
     * Sets the value of the errorData property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorData(String value) {
        this.errorData = value;
    }

    /**
     * Gets the value of the errorDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getErrorDate() {
        return errorDate;
    }

    /**
     * Sets the value of the errorDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setErrorDate(XMLGregorianCalendar value) {
        this.errorDate = value;
    }

    /**
     * Gets the value of the subError property.
     * 
     * @return
     *     possible object is
     *     {@link ErrorInfo }
     *     
     */
    public ErrorInfo getSubError() {
        return subError;
    }

    /**
     * Sets the value of the subError property.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorInfo }
     *     
     */
    public void setSubError(ErrorInfo value) {
        this.subError = value;
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
