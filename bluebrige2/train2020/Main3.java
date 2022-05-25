package train2020;

import java.util.ArrayList;
import java.util.List;

/**
 * 	��n�Ľ׳˵�Լ��
 * 	�������n���ڵ�������,Ȼ��1~n��������޸��������е��������,Ȼ�����������ÿ�������ĸ������г˻�(Ҫ��1)
 * 	Ҫ��1��ԭ��:����ÿ����������,����ѡ��ѡ��ѡ,ѡ����ѡ��k��,����ϲ�ѡ��1��,һ����k+1��ѡ��
 *        ֮����Ҫ�����������,��Ϊ�˷�ֹ�ظ�.
 *        �����ĳ˻�ֻ���ڳ�Ԫ����ȫ��ͬʱ,�������ͬ.
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
