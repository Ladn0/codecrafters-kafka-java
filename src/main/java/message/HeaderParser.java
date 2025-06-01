package message;

import java.nio.ByteBuffer;

public interface HeaderParser {

    Header parseHeader(ByteBuffer headerBytes);

}
