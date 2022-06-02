package qrxedu.offer;

import java.util.Arrays;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Offer11 {
    public int minArray1(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[0];
    }
    public int minArray2(int[] numbers) {
        int n = numbers.length;
        int min = numbers[0];
        for(int i = 1; i < n; i++){
            min = Math.min(min,numbers[i]);
        }
        return min;
    }
}
