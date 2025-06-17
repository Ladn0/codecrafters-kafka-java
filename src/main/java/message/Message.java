package message;

public interface Message<H extends Header, B extends Body> {
    int getMessageSize();
    void setMessageSize(int messageSize);

    H getHeader();
    void setHeader(H header);

    B getBody();
    void setBody(B body);
}
