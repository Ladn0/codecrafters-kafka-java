package request.header;

import message.Header;

public interface RequestHeader extends Header {
    short getRequestApiVersion();
    void setRequestApiVersion(short v);

    short getRequestApiKey();
    void setRequestApiKey(short k);
}
