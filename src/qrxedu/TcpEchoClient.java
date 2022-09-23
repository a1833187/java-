package qrxedu;

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
        socket = new Socket(serverIp,serverPort);
    }

    public void start() throws IOException {
        System.out.println("客户端成功启动");
        Scanner scanner = new Scanner(System.in);
            try(InputStream inputStream = socket.getInputStream()) {
                try(OutputStream outputStream = socket.getOutputStream()){
                    while(true){
                    String request = scanner.next();
                    PrintWriter printWriter = new PrintWriter(outputStream);
                    printWriter.println(request);
                    printWriter.flush();

                    Scanner scan = new Scanner(inputStream);
                    String response = scan.next();

                    System.out.println("request:" + request + ",response:" + response);

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        TcpEchoClient client = new TcpEchoClient("127.0.0.1",9090);
        client.start();
    }
}
