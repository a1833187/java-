package qrxedu.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 服务器:被动接受请求
 * @author qiu
 * @version 1.8.0
 */
@SuppressWarnings("all")
public class UdpEchoServer {
    private DatagramSocket datagramSocket = null;
    public UdpEchoServer(int port) throws SocketException {
        //服务器必须有明确的端口号,因为客户端需要具体指定发送到哪个服务器
        datagramSocket = new DatagramSocket(port);
    }
    //启动服务器
    public void start() throws IOException {

        System.out.println("启动服务器");



        while(true){
            //读取客户端请求:用DatagramPacket去包装并接收客户端发送的请求
            DatagramPacket receivePacket = new DatagramPacket(new byte[1024],1024);
            //receive 会产生一直阻塞等待 客户端发送请求
            datagramSocket.receive(receivePacket);


            //getLength 是客户端中实际输出的数据的大小,不一定是1024
            //根据请求去计算响应  回响程序这一步省略
            String request = new String(receivePacket.getData(),0,receivePacket.getLength(),"utf-8");
            String response = process(request);


            // response.getBytes().length  不能切换成 response.length()  前者是字节的个数,后者是字符的个数
            //同时也需要标明这个响应是发送给谁的.getSocketAddress 包含客户端的IP和地址
            //将响应发送回客户端:跟接收请求类似,但是需要指明这个响应具体是发送给哪个客户端的.
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(),response.getBytes().length
            ,receivePacket.getSocketAddress());
            datagramSocket.send(responsePacket);
            System.out.println("[" + receivePacket.getAddress() + ":" + receivePacket.getPort() + "]" +
                    ",request:" + request + ",response:" + response);

        }
    }
    //根据请求计算响应,这个方法是 最复杂的,最核心的代码.但回响程序 不需要计算响应
    public String process(String request){
        return request;
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer server = new UdpEchoServer(9090);
        server.start();
    }
}
