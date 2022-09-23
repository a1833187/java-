package qrxedu.thread;

/**
 * @author qiu
 * @version 1.8.0
 */
public class SingleTon{

    private SingleTon(){

    }
    private enum SingleTonInstance{
        INSTANCE;
        private SingleTon instance;

        SingleTonInstance(){
            instance = new SingleTon();
        }

        private SingleTon getInstance(){
            return instance;
        }
    }
    public static SingleTon getInstance(){
        return SingleTonInstance.INSTANCE.getInstance();
    }
}
class SingTon1{
    private static SingTon1 singTon1 = new SingTon1();
    private SingTon1(){

    }
    public SingTon1 getSingTon1(){
        return singTon1;
    }
}
