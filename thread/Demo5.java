package qrxedu;

import java.io.PrintStream;
import java.util.Arrays;

/**
 * 阻塞队列简单实现
 * @author qiu
 * @version 1.8.0
 */
public class Demo5 {
    private int[] data = new int[1000];
    private int size = 0;
    private int head = 0;
    private int tail = 0;
    synchronized public void put(int val) throws InterruptedException {
        if(size == data.length){
            this.wait();
        }
        data[tail] = val;
        tail++;
        //模拟循环，可以用求余，也可以用这种直接赋值的方式更直观。
        if(tail == data.length){
            tail = 0;
        }
        size++;
        this.notify();
    }
    synchronized public Integer take() throws InterruptedException {
        if(size == 0){

            this.wait();
        }
        int res = data[head];
        head++;
        size--;
        //模拟循环
        if(head == data.length){
            head = 0;
        }
        this.notify();
        return res;
    }
}
class MyBlockQueue{

}

