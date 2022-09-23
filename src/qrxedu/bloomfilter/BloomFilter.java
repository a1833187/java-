package qrxedu.bloomfilter;

import java.util.BitSet;

/**
 * @author qiu
 * @version 1.8.0
 */
public class BloomFilter {
    public BitSet bitSet;
    public int usedSize;
    SimpleHash[] simpleHashes;

    static final int DEFAULT_SIZE = 1 << 16;
    final int[] seeds = {5,7,11,13,17,19};
    public BloomFilter(){
        bitSet = new BitSet(DEFAULT_SIZE);
        simpleHashes = new SimpleHash[seeds.length];
        for(int i = 0; i < simpleHashes.length; i++){
            simpleHashes[i] = new SimpleHash(DEFAULT_SIZE,seeds[i]);
        }
    }

    public void add(String val){
        for(int i = 0; i < simpleHashes.length; i++){
            int hash = simpleHashes[i].hash(val);
            bitSet.set(hash);
            usedSize++;
        }
    }
    public boolean contains(String val){
        for(SimpleHash s : simpleHashes){
            int hash = s.hash(val);
            if(!bitSet.get(hash)){
                return false;
            }
        }
        System.out.println(val + "可能存在");
        return true;
    }
}

class SimpleHash{
    public int cap;
    public int seed;
    public SimpleHash(int cap,int seed){
        this.cap = cap;
        this.seed = seed;
    }
    final int hash(String key){
        int h;
        return (key == null) ? 0 : (seed * (cap - 1)) &((h = key.hashCode()) ^ (h >>> 16));

    }
}
