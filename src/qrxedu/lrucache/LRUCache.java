package qrxedu.lrucache;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author qiu
 * @version 1.8.0
 */
public class LRUCache {
    public static void main(String[] args) {
        LinkedHashMap<Integer,Integer> linkedHashMap = new LinkedHashMap(10);
        linkedHashMap.put(1,1);
        linkedHashMap.put(2,1);
        linkedHashMap.put(3,1);
        System.out.println(linkedHashMap.get(2));
        System.out.println(linkedHashMap);
    }

    static class LinkNode{
        public int key;
        public int value;
        public LinkNode prev;
        public LinkNode next;

        public LinkNode(int key,int val){
            this.key = key;
            this.value = val;
        }
        public LinkNode(){

        }
    }
    public LinkNode head;
    public LinkNode tail;
    public int usedSize;
    public int capacity;
    public Map<Integer,LinkNode> cache;
    public LRUCache(int capacity){
        this.head = new LinkNode();
        this.tail = new LinkNode();
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
        cache = new HashMap<>();
    }
    public void put(int key,int val){
        if(cache.get(key) != null){
            LinkNode node = cache.get(key);
            moveToTail(node);
        }else{
            LinkNode node = new LinkNode(key,val);
            cache.put(key,node);
            addToTail(node);
            usedSize++;
            if(usedSize > capacity){
                cache.remove(key);
                usedSize--;
                removeHead();
            }
        }
    }
    public LinkNode get(int key){
        LinkNode node = cache.get(key);
        if(node == null){
            return new LinkNode(-1,-1);
        }else{
            moveToTail(node);
            return node;
        }
    }
    private void moveToTail(LinkNode node){
        removeNode(node);
        addToTail(node);
    }
    private void removeNode(LinkNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void addToTail(LinkNode node){
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }
    private LinkNode removeHead(){
        LinkNode cur = head.next;
        head.next = cur.next;
        cur.next.prev = head;
        return cur;
    }
    public void printNodes(){

    }
}
