package qrxedu;

import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;

/**
 * @author qiu
 * @version 1.8.0
 */
public class UdpDictServer extends UdpEchoServer{
    private HashMap<String,String> dict = new HashMap<>();

    public UdpDictServer(int port) throws SocketException {
        super(port);
        dict.put("flower","花");
        dict.put("byte","字节");
        dict.put("red","红色");
        dict.put("lion","狮子");
    }

    @Override
    public String process(String request) {
        return dict.getOrDefault(request,"该词不存在");
    }

    public static void main(String[] args) throws IOException {
        UdpDictServer server = new UdpDictServer(9090);
        server.start();
    }
}