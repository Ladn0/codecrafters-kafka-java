package message;

public class Request {

    private int messageSize;
    private Header header;

    public Request() {
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

    @Override
    public String toString() {
        return "Request{" +
                "messageSize=" + messageSize +
                ", header=" + header +
                '}';
    }
}
