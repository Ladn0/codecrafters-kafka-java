package parser;

import parser.header.HeaderParser;
import request.Request;
import request.header.RequestHeader;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class RequestParser {

    private HeaderParser headerParser;

    public RequestParser(HeaderParser headerParser) {
        this.headerParser = headerParser;
    }

    public Request parseRequest (InputStream inputStream) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        int messageSize = dataInputStream.readInt();
        byte[] data = new byte[messageSize];
        System.out.println(data.length);

        dataInputStream.readFully(data);

        ByteBuffer buffer = ByteBuffer.wrap(data);
        buffer.order(ByteOrder.BIG_ENDIAN);

        RequestHeader header = headerParser.parseHeader(buffer);

        Request request = new Request();
        request.setMessageSize(messageSize);
        request.setHeader(header);

        return request;
    }

}
