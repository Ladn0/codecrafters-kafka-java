package message;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class HeaderV2Parser implements HeaderParser{

    @Override
    public Header parseHeader(ByteBuffer buffer) {
        RequestHeaderV2 header = new RequestHeaderV2();
        header.setRequestApiKey(buffer.getShort());
        header.setRequestApiVersion(buffer.getShort());
        header.setCorrelationId(buffer.getInt());
//        System.out.println("!");
//
//        int stringLength = buffer.getShort();
//        if(stringLength != -1){
//            byte[] clientIdBytes = new byte[stringLength];
//            buffer.get(clientIdBytes, 0, stringLength);
//            String clientId = new String(clientIdBytes, StandardCharsets.UTF_8);
//            header.setClientId(clientId);
//        }else{
//            header.setClientId(null);
//        }
        header.setClientId(null);
        header.setTagBuffer(null);

        return header;
    }

}
