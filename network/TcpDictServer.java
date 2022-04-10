package qrxedu.network;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author qiu
 * @version 1.8.0
 */
public class TcpDictServer extends TcpThreadPoolEchoServer{
    private HashMap<String,String> dict = new HashMap<>();
    public TcpDictServer(int port) throws IOException {
        super(port);
        dict.put("cat","小猫");
        dict.put("tiger","大猫");
        dict.put("qiu","邱瑞翔");
        dict.put("wa","哇");
    }

    @Override
    public String process(String request) {
        return dict.getOrDefault(request,"该词无法被翻译");
    }

    public static void main(String[] args) throws IOException {
        TcpDictServer server = new TcpDictServer(9090);
        server.start();
    }
}
