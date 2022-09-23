package qrxedu;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author qiu
 * @version 1.8.0
 */
@SuppressWarnings("all")
public class TcpThreadPoolEchoServer {
    private ServerSocket listenSocket = null;

    public TcpThreadPoolEchoServer(int port) throws IOException {
        listenSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        while (true) {
            Socket socket = listenSocket.accept();
            ExecutorService t = Executors.newCachedThreadPool();
            t.submit(new Runnable() {
                @Override
                public void run() {
                    processConnection(socket);
                }
            });


        }
    }

    public void processConnection(Socket socket) {
        System.out.println("[" + socket.getInetAddress().toString() + ","
                + socket.getPort() + "]" + ",与服务器成功建立连接");

        try (InputStream inputStream = socket.getInputStream()) {
            try (OutputStream outputStream = socket.getOutputStream()) {
                Scanner scan = new Scanner(inputStream);
                while (true) {
                    if (!scan.hasNext()) {
                        System.out.println("[" + socket.getInetAddress().toString() + ","
                                + socket.getPort() + "]" + ",与服务器断开连接");
                        break;
                    }
                    String request = scan.next();

                    String response = process(request);
                    PrintWriter printWriter = new PrintWriter(outputStream);
                    printWriter.println(response);
                    //因为传送的数据 首先先到缓冲区,等到缓冲区中收到足够多的数据后,再传入文件.flush的作用就是强制将缓冲区的数据写到文件中
                    printWriter.flush();
                    System.out.println("[" + socket.getInetAddress().toString() + ","
                            + socket.getPort() + "]" + "request:" + request + ",response:" +
                            response);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpThreadPoolEchoServer server = new TcpThreadPoolEchoServer(9090);
        server.start();
    }
}