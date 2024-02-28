package kz.esb.enums;

public enum EsbQualifier {

    /**
     * Request.
     */
    REQUEST("request"),

    /**
     * Response.
     */
    RESPONSE("response");

    private String value;

    EsbQualifier(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static boolean isValidValue(String value) {
        return REQUEST.value.equals(value) || RESPONSE.value.equals(value);
    }
}
