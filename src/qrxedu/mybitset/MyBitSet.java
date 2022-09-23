package qrxedu.mybitset;

import java.util.Arrays;
import java.util.BitSet;

/**
 * @author qiu
 * @version 1.8.0
 */
public class MyBitSet {
    private byte[] bitSet;
    private int userSize;

    public MyBitSet(){
        this.bitSet = new byte[1];
    }
    public MyBitSet(int n){
        this.bitSet = new byte[n/8+(byte)1];
    }

    public byte[] getBitSet() {
        return bitSet;
    }

    public void setBitSet(byte[] bitSet) {
        this.bitSet = bitSet;
    }

    public int getUserSize() {
        return userSize;
    }

    public void setUserSize(int userSize) {
        this.userSize = userSize;
    }

    public void set(int val){
        if(val < 0){
            throw new IndexOutOfBoundsException();
        }
        int arrIndex = val / 8;
        //扩容
        while(arrIndex >= bitSet.length){
            bitSet = Arrays.copyOf(bitSet,2*bitSet.length);
        }
        int bitIndex = val % 8;

        bitSet[arrIndex] |= (1<< bitIndex);

        userSize++;
    }
    public boolean get(int val){
        if(val < 0){
            throw new IndexOutOfBoundsException();
        }
        int arrIndex = val / 8;
        int bitIndex = val % 8;
        return ((bitSet[arrIndex] >> bitIndex) & 1) != 0;
    }
    public int getSize(){
        return userSize;
    }

    /**
     * 去掉某个元素
     * @param val
     */
    public void reSet(int val){
        if(val < 0){
            throw new IndexOutOfBoundsException();
        }
        int arrayIndex = val / 8;
        int bitIndex = val % 8;
        if((bitSet[arrayIndex] & (1 << bitIndex)) != 0){
            userSize--;
        }
        bitSet[arrayIndex] &= ~(1 << bitIndex);

    }
}
