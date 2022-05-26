package train2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main2 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for(int i = 2; i <= 2019; i++) {
			if(isSu(i)) {
				list.add(i);
			}
		}
		int n = list.size();
		long[] f = new long[2020];
		Arrays.fill(f,Integer.MIN_VALUE);
		f[0] = 1;
		for(int i = 0; i < n; i++) {
			for(int j = 2019; j >= list.get(i); j--) {
				if(f[j] >= 0 && f[j-list.get(i)] >= 0) {
					f[j] = f[j] + f[j-list.get(i)];
				}
				if(f[j] < 0 && f[j-list.get(i)] >= 0) {
					f[j] = f[j-list.get(i)];
				}
			}
		}
		System.out.println(f[2019]);
	}
	public static boolean isSu(int n) {
		if(n == 2) {
			return true;
		}
		for(int i = 2; i * i <= n; i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
