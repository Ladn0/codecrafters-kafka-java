package response;

import message.Message;
import response.body.ResponseBody;
import response.header.ResponseHeader;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Response implements Message<ResponseHeader, ResponseBody> {

    private int messageSize;
    private ResponseHeader header;
    private ResponseBody body;

    public Response() {
    }

    @Override
    public int getMessageSize() {
        return messageSize;
    }

    @Override
    public void setMessageSize(int messageSize) {
        this.messageSize = messageSize;
    }

    @Override
    public ResponseHeader getHeader() {
        return header;
    }

    @Override
    public void setHeader(ResponseHeader header) {
        this.header = header;
    }

    @Override
    public ResponseBody getBody() {
        return body;
    }

    @Override
    public void setBody(ResponseBody body) {
        this.body = body;
    }

    public byte[] getBytes(){

        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.order(ByteOrder.BIG_ENDIAN);

        buffer.putInt(this.messageSize);
        buffer.put(this.header.getBytes());
        buffer.put(this.body.getBytes());

        return buffer.array();
    }

    @Override
    public String toString() {
        return "Response{" +
                "messageSize=" + messageSize +
                ", header=" + header +
                ", body=" + body +
                '}';
    }
}
