package qrxedu.mybitset;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Test {
    public static void main(String[] args) {
        int[] arr = {1,2,3,10,18,150};
        MyBitSet bitSet = new MyBitSet(18);
        for(int i = 0; i < arr.length; i++){
            bitSet.set(arr[i]);
        }

        for(int i = 0; i < bitSet.getBitSet().length;i++){
            for(int j = 0; j < 8; j++){
                if((bitSet.getBitSet()[i] & (1 << j)) != 0){
                    System.out.println((i*8+j) + " ");
                }
            }
        }
        System.out.println(bitSet.getSize());
        System.out.println(bitSet.get(150));
    }
}
