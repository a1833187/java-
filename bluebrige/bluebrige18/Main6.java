package bluebrige18;

import java.util.Arrays;
import java.util.Scanner;

public class Main6 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		Integer[] a = new Integer[n];
		Integer[] b = new Integer[n];
		Integer[] c = new Integer[n];
		long cnt = 0;
		for(int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		for(int i = 0; i < n; i++) {
			b[i] = scanner.nextInt();
		}
		for(int i = 0; i < n; i++) {
			c[i] = scanner.nextInt();
		}
		Arrays.sort(a);
		Arrays.sort(b);
		Arrays.sort(c);
		int i = 0,k = 0;
		for(int j = 0; j < n; j++) {
			while(i < n && b[j] > a[i]) {
				i++;
			}
			while(k < n && c[k] <= b[j]) {
				k++;
			}
			cnt += (long)i * (n-k);
		}
		System.out.print(cnt);
	}
}
