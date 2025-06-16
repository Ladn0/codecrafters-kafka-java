package message;

public enum ApiVersionsErrorCode {
    UNSUPPORTED_VERSION((short) 35);

    private final short code;

    ApiVersionsErrorCode(short code) {
        this.code = code;
    }

    public short getCode(){
        return code;
    }
}
