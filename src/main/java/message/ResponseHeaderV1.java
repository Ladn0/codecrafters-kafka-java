package message;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ResponseHeaderV1 implements Header{

    private int correlationId;

    public ResponseHeaderV1() {
    }

    public ResponseHeaderV1(int correlationId) {
        this.correlationId = correlationId;
    }

    public int getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(int correlation_id) {
        this.correlationId = correlation_id;
    }

    @Override
    public byte[] getBytes(){
        ByteBuffer buffer = ByteBuffer.allocate(4);
        buffer.order(ByteOrder.BIG_ENDIAN);
        buffer.putInt(correlationId);

        return buffer.array();
    }
}
