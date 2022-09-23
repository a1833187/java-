package qrxedu;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class UdpEchoClient {
    private DatagramSocket socket = null;
    private String serverIp;
    private int serverPort;
    public UdpEchoClient(String ip,int port) throws SocketException {
        socket = new DatagramSocket();
        serverIp = ip;
        serverPort = port;
    }

    public void start() throws IOException {
        while(true){
            Scanner scanner = new Scanner(System.in);
            String request = scanner.next();

            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(),request.getBytes().length, InetAddress.getByName(serverIp),serverPort);
            socket.send(requestPacket);

            DatagramPacket responsePacket = new DatagramPacket(new byte[1024],1024);
            socket.receive(responsePacket);

            String response = new String(responsePacket.getData(),0,responsePacket.getLength(),"utf-8");
            System.out.println("request:"+ request + ",response:" + response);
        }
    }

    public static void main(String[] args) throws IOException {
        UdpEchoClient client = new UdpEchoClient("127.0.0.1",9090);
        client.start();
    }
}
