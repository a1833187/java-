package train2017;

import java.util.Scanner;
public class Main5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int[] cnt = new int[100010];
		int ans = 0;
		int[] f = new int[100010];
		for(int i = 0; i < n; i++) {
			int num = scanner.nextInt();
			cnt[num]++;
		}
		if(k == 0) {
			for(int i = 0; i < cnt.length; i++) {
				if(cnt[i] != 0) {
					ans++;
				}
			}
			System.out.println(ans);
			return;
		}
		ans = 0;
		for(int i = 0; i < k; i++) {
			int[] cur = new int[100010];
			int m = 0;
			for(int j = i;j <= 100000; j+=k) {
				cur[m++] = cnt[j];
			}
			for(int j = 1; j < m; j++) {
				if(j == 1) {
					f[j] = Math.max(f[0], cur[j]);
				}else {
					f[j] = Math.max(f[j-1], f[j-2]+cur[j]);
				}
			}
			ans += f[m-1];
		}
		System.out.println(ans);
	}
}
