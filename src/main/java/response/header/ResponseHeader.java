package response.header;

import message.Header;

public interface ResponseHeader extends Header {
    byte[] getBytes();
}
