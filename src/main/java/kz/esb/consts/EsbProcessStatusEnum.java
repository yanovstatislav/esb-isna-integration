package kz.esb.consts;

public enum EsbProcessStatusEnum {

    /**
     * Accepted
     */
    ACCEPTED(0),

    /**
     * Ready to response
     */
    RESPONSE_READY(1);

    private int status;

    EsbProcessStatusEnum(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
