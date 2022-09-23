package qrxedu.e101;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * LRU:每次删掉最长时间未使用的
 * @author qiu
 * @version 1.8.0
 */
public class E100 {
    private int size = 0;
    private HashMap<Integer,Integer> map;
    private LinkedList<Integer> list;
    public E100(int capacity) {
        // write code here
        list = new LinkedList<>();
        map = new HashMap<>();
        size = capacity;
    }

    public int get(int key) {
        // write code here
        if(!map.containsKey(key)){
            return -1;
        }
        list.remove((Integer) key);
        list.addFirst(key);
        return map.get(key);
    }

    public void set(int key, int value) {
        // write code here
        if(size == 0){
            int c = list.removeLast();
            map.remove(c);
            size++;
        }
        map.put(key,value);
        list.addFirst(key);
        size--;
    }

    public static void main(String[] args) {
        E100 e = new E100(2);
        e.set(1,1);
        e.set(2,2);
        System.out.println(e.get(1));
        e.set(3,3);
        System.out.println(e.get(2));
        e.set(4,4);
        System.out.println(e.get(1));
        System.out.println(e.get(3));
        System.out.println(e.get(4));
    }

}
