package message;

public interface Header {
    byte[] getBytes();

    int getCorrelationId();
}
