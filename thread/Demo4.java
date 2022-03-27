package qrxedu;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Demo4 {
    /**
    将一部分功能单独分离出来只针对该问题进行处理
    阻塞队列 ---> 生产者消费者模型：
    优点：
        1.能够使多个服务器之间进行更充分的解耦合
        2.能够对于请求进行"削峰填谷"：不会因为服务器A请求的波动而使服务器B崩溃
     */
    public static void main(String[] args) throws InterruptedException {
        BlockingDeque<String> blockingDeque = new LinkedBlockingDeque<>();
        blockingDeque.put("哈哈哈");
        String str = blockingDeque.take();
    }
}
