package message;

public enum ApiVersionsErrorCode {
    UNSUPPORTED_VERSION((short) 35),
    NONE((short) 0);

    private final short code;

    ApiVersionsErrorCode(short code) {
        this.code = code;
    }

    public short getCode(){
        return code;
    }
}
