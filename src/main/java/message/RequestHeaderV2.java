package message;

import java.lang.reflect.Array;

public class RequestHeaderV2 implements Header{

    private short requestApiKey;
    private short requestApiVersion;
    private int correlationId;
    private String clientId;
    private Array tagBuffer;

    public RequestHeaderV2() {
    }

    public short getRequestApiKey() {
        return requestApiKey;
    }

    public void setRequestApiKey(short requestApiKey) {
        this.requestApiKey = requestApiKey;
    }

    public short getRequestApiVersion() {
        return requestApiVersion;
    }

    public void setRequestApiVersion(short requestApiVersion) {
        this.requestApiVersion = requestApiVersion;
    }

    public int getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(int correlationId) {
        this.correlationId = correlationId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Array getTagBuffer() {
        return tagBuffer;
    }

    public void setTagBuffer(Array tagBuffer) {
        this.tagBuffer = tagBuffer;
    }

    @Override
    public byte[] getBytes() {
        return new byte[0];
    }

    @Override
    public String toString() {
        return "RequestHeaderV2{" +
                "requestApiKey=" + requestApiKey +
                ", requestApiVersion=" + requestApiVersion +
                ", correlationId=" + correlationId +
                ", clientId='" + clientId + '\'' +
                ", tagBuffer=" + tagBuffer +
                '}';
    }
}
