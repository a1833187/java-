package qrxedu.network;

import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;

/**
 * @author qiu
 * @version 1.8.0
 */
public class UdpTranslateServer extends UdpEchoServer{
    private HashMap<String,String> dict = new HashMap<>();
    public UdpTranslateServer(int port) throws SocketException {
        super(port);
        dict.put("cat","小猫");
        dict.put("dog","小狗");
        dict.put("qiu","邱瑞翔");
        dict.put("hi","你好");
    }

    @Override
    public String process(String request) {
        return dict.getOrDefault(request,"该词无法被翻译");
    }

    public static void main(String[] args) throws IOException {
        UdpTranslateServer server = new UdpTranslateServer(9090);
        server.start();
    }
}
