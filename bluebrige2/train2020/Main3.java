package train2020;

import java.util.ArrayList;
import java.util.List;

/**
 * 	求n的阶乘的约数
 * 	首先求出n以内的素数集,然后将1~n化简成有限个素数集中的素数相乘,然后对素数集中每个素数的个数进行乘积(要加1)
 * 	要加1的原因:对于每个素数而言,可以选择选或不选,选可以选择k个,外加上不选的1种,一共是k+1中选择
 *        之所以要化简成素数集,是为了防止重复.
 *        素数的乘积只有在乘元素完全相同时,结果才相同.
 * @author qiu
 *
 */
public class Main3 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for(int i = 2; i <= 100; i++) {
			if(isSu(i)) {
				list.add(i);
			}
		}
		int n = list.size();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = list.get(i);
		}
		int[] count = new int[n];
		for(int i = 1; i <= 100; i++) {
			for(int j = 0; j < n; j++) {
				int k = i;
				while(k % arr[j] == 0) {
					count[j]++;
					k /= arr[j];
				}
			}
		}
		long ans = 1;
		for(int i = 0; i < n; i++) {
			ans *= (count[i]+1);
		}
		System.out.println(ans);
	}
	public static boolean isSu(int n) {
		if(n == 2) {
			return true;
		}
		if(n < 2) {
			return false;
		}
		for(int i = 2; i * i <= n; i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
