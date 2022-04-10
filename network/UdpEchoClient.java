package qrxedu.network;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * 客户端:主动发送请求
 * @author qiu
 * @version 1.8.0
 */
@SuppressWarnings("all")
public class UdpEchoClient {
    private DatagramSocket socket = null;
    //客户端的Ip地址
    private String serverIp;
    //客户端的端口号
    private int serverPort;

    public UdpEchoClient(String ip,int port) throws SocketException {
        //由操作系统随机分配一个闲置的端口号,避免了手动指定的端口号被占用而导致无法正常发送请求
        //同时因为服务器是被动接收请求,接收到的数据的地址可以通过数据报相应的API得到
        socket = new DatagramSocket();
        serverIp = ip;
        serverPort = port;
    }

    public void start() throws IOException {
        while(true){
            //1.读取用户的输入
            Scanner scanner = new Scanner(System.in);
            String request = scanner.next();

            //2.将用户的输入包装成一个udp请求发送给指定的服务器
            //注意需要指定具体的服务器的IP地址和端口号
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(),request.getBytes().length
                    ,InetAddress.getByName(serverIp),serverPort);
            socket.send(requestPacket);

            //3.接收服务器返回的响应并解析

            DatagramPacket responsePacket = new DatagramPacket(new byte[1024],1024);
            socket.receive(responsePacket);
            String response = new String(responsePacket.getData(),0,responsePacket.getLength(),"utf-8");
            //4.输出解析后的响应
            System.out.println("request:" + request + ",response:" + response);
        }
    }

    public static void main(String[] args) throws IOException {
        UdpEchoClient client = new UdpEchoClient("127.0.0.1",9090);
        client.start();
    }
}

/*
五元组:完成一次网络通信的基本要点
源Ip,源端口,目的Ip,目的端口,协议类型
 */
