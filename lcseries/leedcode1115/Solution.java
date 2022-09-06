package qrxedu.lcseries.leedcode1115;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    private int n;
    private Object o1 = new Object();
    private Object o2 = new Object();
    public Solution(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            synchronized(o1){
                printFoo.run();
            }
            o1.wait();
            o2.notify();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printBar.run() outputs "bar". Do not change or remove this line.
            synchronized(o2){
                printBar.run();
            }
            o2.wait();
            o1.notify();
        }
    }
}
