package qrxedu.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class TcpEchoClient {
    private Socket socket = null;

    public TcpEchoClient(String serverIp,int serverPort) throws IOException {
        //这里的Ip地址和端口号指的是该客户端与 哪一个具体的服务器建立连接
        socket = new Socket(serverIp,serverPort);

    }

    public void start(){
        System.out.println("和服务器连接成功");

        Scanner scanner = new Scanner(System.in);
        try(InputStream inputStream = socket.getInputStream()){
            try(OutputStream outputStream = socket.getOutputStream()) {

                while (true) {
                    String request = scanner.next();
                    PrintWriter printWriter = new PrintWriter(outputStream);
                    printWriter.println(request);

                    printWriter.flush();

                    Scanner scanner1 = new Scanner(inputStream);
                    String response = scanner1.next();

                    System.out.println("request:" + request + ",response:" + response );
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        TcpEchoClient client = new TcpEchoClient("127.0.0.1",9090);
        client.start();
    }
}
