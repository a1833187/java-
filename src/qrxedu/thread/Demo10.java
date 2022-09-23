package qrxedu.thread;

import sun.misc.Unsafe;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Demo10 {
    public static void main(String[] args) throws InterruptedException {
        //用CAS实现的原子类，既能保证线程安全，同时也能保证运行效率(不会产生阻塞等待，double)
        AtomicInteger a = new AtomicInteger(0);
        Thread t1 = new Thread(()->{
            for(int i = 0; i < 50000;i++){
                System.out.println(a.getAndIncrement());
            }
        });
        Thread t2 = new Thread(() ->{
            for(int i = 0; i < 50000; i++){
                a.getAndIncrement();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(a.get());

    }
    /*
    Class AtomicInteger{
        private int value;
        public int getAndIncrement(){
            int oldValue = value;
            while(CAS(value,oldValue,oldValue+1)!=true)){
                oldValue = value;
            }
            return oldValue;
        }
    }
    class SpinLock{
        private Thread owner = null;
        public void lock(){
            while(!CAS(owner,null,Thread.currentThread())){

            }
        }
        public void unLock(){
            this.owner = null;
        }
    }
     */
    /*
     锁策略：
     1.悲观锁 vs 乐观锁
     悲观锁：预期锁冲突(锁竞争)的概率很高，引起做的工作更多，付出的更多，更低效。
     乐观锁：预期锁冲突(锁竞争)的概率很低，引起做的工作较少，付出的更少，更高效。
     2.读写锁 vs 互斥锁
     读写锁：加读锁、加写锁、解锁。将读和写分开来加锁，读锁和读锁之间不存在互斥，效率更高。
     普通互斥锁：加锁、解锁
     3.重量级锁 vs 轻量级锁
     重量级锁：为解决锁冲突的问题开销更多
     轻量级锁：为解决锁冲突的问题开销更小。
     一般情况下，重量级锁就是悲观锁，轻量级锁就是乐观锁。只不过一个是原因，一个是结果。
     在使用的锁中，如果锁是基于内核的一些功能来实现的，一般认为是重量级锁
     如果锁是纯基于用户态实现的，一般认为是轻量级锁(用户态的锁更高效，更可控)
     4.挂起等待锁 vs 自旋锁
     挂起等待锁就是 重量级锁的一种具体实现
     自旋锁就是 轻量级锁的一种具体实现
     5.公平锁 vs 非公平锁
     公平锁：多个线程在等待同一把锁的时候，谁先来的谁就先获取到这个锁(遵守先来后到)
     非公平锁:多个线程在等待同一把锁的时候，不遵守先来后到，所有等待的线程获取到这个锁的概率是均等的。
     对于操作系统而言，在优先级相同的前提下，本身线程之间的调度是随机的(均等的),操作系统提供的这个mutex锁就是非公平锁
     要实现公平锁，需要利用类似队列的数据结构将这些线程组织起来，开销更大
     6.可重入锁 vs 不可重入锁
     可重入锁：1个线程能够嵌套加多个相同的锁，如果不产生死锁就是可重入锁
     不可重入锁：1个线程再嵌套多个相同的锁时会发生死锁
     */

    /*
    synchronized的特性(支持jdk1.8)
    1.既是一个乐观锁也是一个悲观锁(根据锁竞争的程度 自适应)
    2.是一把普通的互斥锁，不是读写锁
    3.既是一个重量级锁，也是一个轻量级锁(根据锁竞争的程度，自适应)
    4.轻量级锁的部分基于自旋锁来实现，重量级锁的部分基于挂起等待锁
    5.非公平锁
    6.可重入锁
     */

    /*
    CAS(Compare and Swap) : 挺重要的
    功能：将寄存器/内存中的值A于另一个内存的值B进行比较，如果相等，则将另一个寄存器/内存中的值C和内存的值B进行交换
     此处所谓的CAS指的是 CPU提供了一个单独的CAS指令，完成上述功能。
     由于这条指令是原子的，所以该操作是线程安全的。
     CAS最大的意义就是为线程安全提供了一种新的思路和方向  --- > 很多功能既可以通过硬件实现(CAS指令)，也可以通过软件实现(加锁)
       功能的具体实现：
       1. 基于CAS 实现的 原子类(int long int[] 等等
       2. 基于CAS 实现 自旋锁


      面试题：如何理解CAS中的ABA问题
      CAS全称就是Compare and Swap，就是先将旧值和当前值进行比较，如果相同则给当前值赋予一个新的值。
      这个比较的过程中的相同 也就意味着在这两个值之间没有进行过改变。

      这个没有进行过改变 其实并不严谨，它有可能是通过多次改变之后恰好又和原来的值相同。
      这种从 A 变成 B 又 变成 A的问题就被称为 CAS中的ABA问题。
      ABA问题在大多数情况下是不会有什么影响的，但是在极端巧合的情况下也可能产生意料之外的bug
      比如 提现时本着提现1次的情况 结果由于ATM机卡了一下，你多点了一下。导致两个提现的线程开始并发执行。
      在一般的情况下，这种情况 也只会 体现1次，另1次因为CAS中的Compare方法不相等而导致这次提现失败。
      但是如果再这个比较的时候突然第3个线程向你的账户中转账，导致你的账户余额和你第一次取钱之前的余额是相同的，这就导致了
      你误操作的转账线程也进行了Swap操作，导致你一共提现了2次
     */


    /*
      synchronized 几个典型的优化手段
      1. 锁膨胀/锁升级
          体现了synchronized 的"自适应"的能力
          无锁 --> 偏向锁(首个线程加锁，只是一种标记，并不是真正的加锁)  --> 自旋锁 --> 重量级锁
      2. 锁粗化(细化)
          这里的粗细 指的是"锁的粒度"(代码加锁的涉及的范围)
          细化程度越高，并发性越高
          粗化程度越高，隔离性越高，加锁释放锁的消耗更小。
          如果代码的锁细化程度过高，编译器会适当地粗化。
          锁细化程度越高，
      3. 锁消除
          有些代码虽然加上了锁，但是其实没有加锁的必要，编译器会将这种情况的锁给释放掉
     */

    /*
     JUC(java.util.concurrent) Java中专门用于并发编程的一个包
        Callable 便于描述计算型的任务，任务创建好以后需要用FutureTask需要去包装，包装好以后放入Thread类中进行执行。

        ReentrantLock和Synchronized的区别：
        1. synchronized 是一个关键字(背后的逻辑是 JVM是实现的 C++),ReentrantLock 是一个标准库中的类(背后的逻辑是Java实现的)
        2. synchronized 不需要手动释放锁，出了加锁的范围，锁自动释放，ReentrantLock 必须要手动释放锁
        3. synchronized 竞争锁失败的时候 会触发阻塞等待机制， ReentrantLock 除了阻塞等待之外，还有trylock失败了直接返回。
        4. synchronized 是一把非公平锁，ReentrantLock提供了非公平锁和公平锁
        5. synchronized 的阻塞等待机制主要是基于 wait notify实现的，ReentrantLock的阻塞等待机制是基于condition实现的，功能更丰富一些。

     */

    /*
     信号量(Semaphore):更广义的锁
     锁是信号量的一种特殊情况，叫做"二元信号量"(申请锁(acquire)和释放锁(release))，锁的可用资源就1个，非0即1
     信号量的可用资源有多个，也就是说将锁进行了一种推广

     */

    /*

     */

    /*
    线程安全的集合类
    
     */
}
