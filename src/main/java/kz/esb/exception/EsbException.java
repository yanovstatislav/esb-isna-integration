package kz.esb.exception;

import kz.esb.enums.EsbError;

public class EsbException extends Exception {

    private String raisedBy;
    private String number;
    private String type;
    private String text;

    public EsbException() {
    }

    public EsbException(EsbError gtmError) {
        super(gtmError.getDescription());
        raisedBy = gtmError.getRaisedBy();
        number = gtmError.getCode();
        type = gtmError.getType();
        text = gtmError.getDescription();
    }

    public EsbException(EsbError gtmError, Throwable cause) {
        super(gtmError.getDescription(), cause);
        raisedBy = gtmError.getRaisedBy();
        number = gtmError.getCode();
        type = gtmError.getType();
        text = gtmError.getDescription();
    }

    public EsbException(String raisedBy, String number, String type, String text) {
        super(text);
        this.raisedBy = raisedBy;
        this.number = number;
        this.type = type;
        this.text = text;
    }

    public EsbException(String raisedBy, String number, String type, String text, Throwable cause) {
        super(text, cause);
    }

    public String getRaisedBy() {
        return raisedBy;
    }

    public String getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public String getText() {
        return text;
    }
}
