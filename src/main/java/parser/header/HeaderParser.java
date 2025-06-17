package parser.header;

import request.header.RequestHeader;

import java.nio.ByteBuffer;

public interface HeaderParser {

    RequestHeader parseHeader(ByteBuffer headerBytes);

}
