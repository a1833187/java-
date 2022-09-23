package qrxedu.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
@SuppressWarnings("all")
public class TcpThreadEchoServer {
    private ServerSocket listenSocket = null;

    public TcpThreadEchoServer(int port) throws IOException {
        listenSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");

        while(true){
            //TCP是有连接的,所以需要事先建立连接
            Socket clientSocket = listenSocket.accept();
            Thread t = new Thread(()->{
                processConnection(clientSocket);
            });
            t.start();

        }
    }

    public void processConnection(Socket clientSocket){
        System.out.println("[" + clientSocket.getInetAddress().toString() + ":" + clientSocket.getPort()+ "],客户端建立连接");


        try(InputStream inputStream = clientSocket.getInputStream()){
            try(OutputStream outputStream = clientSocket.getOutputStream()){
                Scanner scanner = new Scanner(inputStream);
                while(true){
                    if(!scanner.hasNext()){
                        System.out.println("[" + clientSocket.getInetAddress().toString() + ":" + clientSocket.getPort()+ "],客户端断开连接");
                        break;
                    }

                    String request = scanner.next();
                    String response = process(request);

                    PrintWriter printWriter = new PrintWriter(outputStream);
                    printWriter.println(response);
                    //刷新缓冲区
                    printWriter.flush();
                    System.out.println("[" + clientSocket.getInetAddress().toString() + ":" + clientSocket.getPort()+ "]," +
                            "request:" + request + ",response:" + response);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                //因为TCP是需要建立连接的,这个连接并不是贯穿程序的始终,所以每次连接处理完之后就需要释放该资源,即clientSocket的生命周期比较短
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public String process(String request){
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpThreadEchoServer server = new TcpThreadEchoServer(9090);
        server.start();
    }
}
