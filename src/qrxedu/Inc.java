package qrxedu;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author qiu
 * @version 1.8.0
 */
@SuppressWarnings("all")
class A{
    public A() {
        System.out.println("A gouzao");
    }

        static A a = new A();
        static{
            System.out.println("static");
        }
        {
            System.out.println("A1");
        }
}
class B extends A{
    public B(){
        System.out.println("B");
    }
}
public class Inc {
    static ThreadLocal<Integer> t2 = new ThreadLocal<>();
    static class Person implements Comparable<Person>{
        int age;
        int store;

        @Override
        public int compareTo(Person o) {
            return this.store - o.store;
        }
    }
    static  Object object = new Object();
    static Object object1 = new Object();
    static int k = 0;
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable c = new Callable() {
            @Override
            public Object call() throws Exception {
                return new String("通过Callable创建线程");
            }
        };
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("通过Runnable来创建线程");
            }
        };
        runnable.run();
        FutureTask<String> f = new FutureTask<>(c);
        Thread t = new Thread(f);
        t.start();
        System.out.println(f.get());

        //        int taskNum = 3;
//        ExecutorService pool = Executors.newFixedThreadPool(taskNum);
//        List<Future> l = new ArrayList<>();
//        for(int i = 0; i < taskNum; i++){
//            Callable c = new Callable() {
//                @Override
//                public Object call() throws Exception {
//                    return new String("该任务是第" + ++k + "个任务");
//                }
//            };
//            Future f = pool.submit(c);
//            l.add(f);
//        }
//        for(int i = 0; i < taskNum; i++){
//            System.out.println(l.get(i).get().toString());
//        }
    }

    public static void func(StringBuffer s,long h){
        if(h == 0){
            s.append("00");
        }else if(h < 10){
            s.append('0');
            s.append(h);
        }else{
            s.append(h);
        }
        s.append(':');
    }

    int fermin(int i) {
        i++;
        return i;
    }
}
//# custom IntelliJ IDEA VM options
//
//        -Xms1024m
//        -Xmx2048m
//        -XX:ReservedCodeCacheSize=240m
//        -XX:+UseConcMarkSweepGC
//        -XX:SoftRefLRUPolicyMSPerMB=50
//        -ea
//        -XX:CICompilerCount=2
//        -Dsun.io.useCanonPrefixCache=false
//        -Djava.net.preferIPv4Stack=true
//        -Djdk.http.auth.tunneling.disabledSchemes=""
//        -XX:+HeapDumpOnOutOfMemoryError
//        -XX:-OmitStackTraceInFastThrow
//        -Djdk.attach.allowAttachSelf=true
//        -Dkotlinx.coroutines.debug=off
//        -Djdk.module.illegalAccess.silent=true
//        -javaagent:c:\windows\rjjm.jar