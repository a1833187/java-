package qrxedu.hashlist;

/**
 * @author qiu
 * @version 1.8.0
 */
public class HashBuck {

    static class Node {
        public int key;
        public int val;
        public Node next;

        public Node(int key,int val) {
            this.key = key;
            this.val = val;
        }
    }

    public Node[] array;
    public int usedSize;
    public static final double LOAD_FACTOR = 0.75;
    public HashBuck() {
        this.array = new Node[10];
        usedSize = 0;
    }
    /**
     * put函数
     * @param key
     * @param val
     */
    public void put(int key,int val) {
        int hash = key % array.length;
        Node cur = array[hash];
            if(cur.key == key){
                cur.val = val;
                return;
            }
            Node newNode = new Node(key,val);
            newNode.next = array[hash];
            array[hash] = newNode;
            usedSize++;
            if(loadFactor() > LOAD_FACTOR){
                resize();
            }

    }

    /**
     * 根据key获取val值
     * @param key
     * @return
     */
    public int get(int key) {
        int hash = key % array.length;
        Node cur = array[hash];
        while(cur != null){
            if(cur.key == key){
                return cur.val;
            }
            cur = cur.next;
        }
        return -1;
    }
    public void resize(){
        Node[] newArray = new Node[array.length * 2];
        for(int i = 0; i < array.length; i++){
            Node cur = array[i];
            while(cur != null){
                int hash = cur.key % newArray.length;
                Node oldNext = cur.next;
                cur.next = newArray[hash];
                newArray[hash] = cur;
                cur = oldNext;
            }
        }
        array = newArray;
    }
    public double loadFactor(){
        return usedSize * 1.0 / array.length;
    }

}

