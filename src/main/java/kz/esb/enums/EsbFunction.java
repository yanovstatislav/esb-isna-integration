package kz.esb.enums;

public enum EsbFunction {

    /**
     * Submit.
     */
    SUBMIT("submit");

    private String value;

    EsbFunction(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static boolean isValidValue(String value) {
        return SUBMIT.value.equals(value);
    }
}
