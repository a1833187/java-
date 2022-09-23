package qrxedu;

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

        dict.put("apple","苹果");
        dict.put("orange","橘子");
        dict.put("pear","梨子");
        dict.put("hello","你好");
    }

    @Override
    public String process(String request) {
        return dict.getOrDefault(request,"该词不存在");
    }

    public static void main(String[] args) throws IOException {
        TcpDictServer server = new TcpDictServer(9090);
        server.start();
    }
}