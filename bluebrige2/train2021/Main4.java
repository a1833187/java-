package train2021;

import java.util.Arrays;

public class Main4 {
	public static void main(String[] args) {
		//从1011 到 2021 节点权重为1.
		long[] w = new long[2022];
		//从 1011 到 2021 节点的左右子树节点的个数均为0
		long[] left = new long[2022];
		long[] right = new long[2022];
		Arrays.fill(left, 1);
		Arrays.fill(right, 1);
		for(int i = 1010; i >= 1; i--) {
			left[i] += left[2*i];
			right[i] += right[2*i+1];
		}
		for(int i = 0; i <= 2021; i++) {
			left[i]-=1;
			right[i]-=1;
		}
		for(int i = 1011; i <= 2021; i++) {
			w[i] = 1;
		}
		for(int i = 1010; i >= 1; i--) {
			w[i] = 1 + 2*w[2*i]+3*w[2*i+1]+2*left[2*i]*right[2*i+1];
		}
		long ans = 0;
		for(long num : w) {
			ans += num;
		}
		System.out.println(ans);
		
	}
}
