package request;

import message.Body;
import message.Header;
import message.Message;
import request.body.RequestBody;
import request.header.RequestHeader;

public class Request implements Message<RequestHeader, RequestBody> {

    private int messageSize;
    private RequestHeader header;
    private RequestBody body;

    public Request() {
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
    public RequestHeader getHeader() {
        return header;
    }

    @Override
    public void setHeader(RequestHeader header) {
        this.header = header;
    }

    @Override
    public RequestBody getBody() {
        return body;
    }

    @Override
    public void setBody(RequestBody body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Request{" +
                "messageSize=" + messageSize +
                ", header=" + header +
                ", body=" + body +
                '}';
    }
}
