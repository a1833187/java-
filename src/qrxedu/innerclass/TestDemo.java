package qrxedu.innerclass;

/**
 * @author qiu
 * @version 1.8.0
 */
public class TestDemo {
    public static void main(String[] args) {
        Fruit fruit = new Fruit();
        Fruit.Apple apple = fruit.new Apple();
        Fruit.Orange orange = new Fruit.Orange();
    }
}
