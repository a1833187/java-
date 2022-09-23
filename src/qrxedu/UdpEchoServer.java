package qrxedu;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author qiu
 * @version 1.8.0
 */
@SuppressWarnings("all")
public class UdpEchoServer {
    private DatagramSocket socket = null;

    public UdpEchoServer(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器成功启动");
        while (true) {
            DatagramPacket requestPacket = new DatagramPacket(new byte[1024], 1024);
            socket.receive(requestPacket);

            String request = new String(requestPacket.getData(), 0, requestPacket.getLength(), "utf-8");
            String response = process(request);

            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(), response.getBytes().length,
                    requestPacket.getSocketAddress());
            socket.send(responsePacket);
            System.out.println("[" + requestPacket.getAddress().toString() + "," + requestPacket.getPort() + "]" + "request:"+
                    request + ",response:" + response);
        }
    }

    public String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer server = new UdpEchoServer(9090);
        server.start();
    }
}
