package message;

public interface Header {
    byte[] getBytes();

    int getCorrelationId();
    short getRequestApiKey();
    short getRequestApiVersion();
}
