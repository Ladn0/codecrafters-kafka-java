import message.*;
import parser.header.HeaderParser;
import parser.header.HeaderV2Parser;
import request.Request;
import parser.RequestParser;
import response.body.ApiVersionsBody;
import response.body.ApiVersionsErrorCode;
import response.Response;
import response.body.ResponseBody;
import response.header.ResponseHeaderV1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
  public static void main(String[] args){
    // You can use print statements as follows for debugging, they'll be visible when running tests.
    System.err.println("Logs from your program will appear here!");

      HeaderParser hp = new HeaderV2Parser();
      RequestParser requestParser = new RequestParser(hp);



     ServerSocket serverSocket = null;
     Socket clientSocket = null;
     int port = 9092;
     try {
       serverSocket = new ServerSocket(port);
       // Since the tester restarts your program quite often, setting SO_REUSEADDR
       // ensures that we don't run into 'Address already in use' errors
       serverSocket.setReuseAddress(true);
       // Wait for connection from client.
       clientSocket = serverSocket.accept();

       InputStream inputStream =  clientSocket.getInputStream();
       Request request = requestParser.parseRequest(inputStream);

       int correlationId = request.getHeader().getCorrelationId();

       Response response = new Response();
       response.setMessageSize(0);
       response.setHeader(new ResponseHeaderV1(correlationId));

         System.out.println(request.toString());
       // Create message body
         ResponseBody body;
         if (request.getHeader().getRequestApiVersion() < 0 || request.getHeader().getRequestApiVersion() > 4) {
             body = new ApiVersionsBody(ApiVersionsErrorCode.UNSUPPORTED_VERSION);
         }else{
             body = new ApiVersionsBody(ApiVersionsErrorCode.NONE);
         }
         response.setBody(body);

         OutputStream out = clientSocket.getOutputStream();
         out.write(response.getBytes());
         out.flush();

     } catch (IOException e) {
       System.out.println("IOException: " + e.getMessage());
     } finally {
       try {
         if (clientSocket != null) {
           clientSocket.close();
         }
         if (serverSocket != null){
             serverSocket.close();
         }
       } catch (IOException e) {
         System.out.println("IOException: " + e.getMessage());
       }
     }
  }
}
