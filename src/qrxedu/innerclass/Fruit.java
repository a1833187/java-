package qrxedu.innerclass;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Fruit {
    public int val = 2;
    static int m = 4;
    class Apple{
        public int val = 3;
        public void show(){
            System.out.println(val);
            System.out.println(new Fruit().val);

        }
    }
    static class Orange{
        static int m = 5;
        public void func(){
            System.out.println(m);
            System.out.println(Fruit.m);
            Integer [] arr = {1,2,3,4,5};
            Arrays.sort(arr, new Comparator<Integer>()
            {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            });
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            });
        }
    }

}
