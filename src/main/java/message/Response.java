package message;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Response {

    private int messageSize;
    private Header header;
    private MessageBody messageBody;

    public Response() {
    }

    public int getMessageSize() {
        return messageSize;
    }

    public void setMessageSize(int messageSize) {
        this.messageSize = messageSize;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public MessageBody getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(MessageBody messageBody) {
        this.messageBody = messageBody;
    }

    public byte[] getBytes(){

        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.order(ByteOrder.BIG_ENDIAN);

        buffer.putInt(this.messageSize);
        buffer.put(this.header.getBytes());
        buffer.put(this.messageBody.getBytes());

        return buffer.array();
    }
}
