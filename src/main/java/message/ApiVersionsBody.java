package message;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ApiVersionsBody implements MessageBody{

    private ApiVersionsErrorCode errorCode;

    public ApiVersionsBody(ApiVersionsErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ApiVersionsErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ApiVersionsErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public byte[] getBytes() {
        ByteBuffer buffer = ByteBuffer.allocate(2);
        buffer.order(ByteOrder.BIG_ENDIAN);
        buffer.putShort(this.errorCode.getCode());

        return buffer.array();
    }
}
