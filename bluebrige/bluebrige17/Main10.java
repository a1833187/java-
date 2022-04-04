package bluebrige17;

import java.util.Scanner;
public class Main10 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int[] arr = new int[n+1];
		for(int i = 1; i <= n; i++) {
			arr[i] = scanner.nextInt() + arr[i-1];
		}
		int[] f = new int[n+1];
		f[0] = 1;
		long ans = 0;
		for(int i = 1; i <= n; i++) {
			ans += f[arr[i] % k];
			f[arr[i] % k] ++;
		}
		System.out.println(ans);
	}
}
