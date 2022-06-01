package train2016;

import java.util.Scanner;
public class Main4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int h = (int)Math.sqrt(2*(a+b));
		int[] dp = new int[h+1];
		long ans = 0;
		for(int i = 0; i < 1<<h; i++) {
			int curH = h;
			int curA = 0,curB = 0;
			for(int j = 0; j < curH; j++) {
				if(((i >> j) & 1) == 1) { 
					dp[j] = 1;
					curA++;
				}else {
					dp[j] = 0;
					curB++;
				}
			}
			while(--curH > 0) {
				for(int j = 0; j < curH-1; j++) {
					if(dp[j] == dp[j+1]) {
						dp[j] = 1;
						curA++;
					}else {
						dp[j] = 0;
						curB++;
					}
				}
			}
			if(curA == a && curB == b) {
				ans++;
			}
		}
		System.out.println(ans);
	}
}
