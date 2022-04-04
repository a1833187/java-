package bluebrige17;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;
public class Main8 {
	public static int gcd(int n1,int n2) {
		int m1 = Math.max(n1, n2);
		int m2 = Math.min(n1, n2);
		int r = m1 % m2;
		while(r != 0) {
			m1 = m2;
			m2 = r;
			r = m1 % m2;
		}
		return m2;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int g = 0;
		TreeSet<Integer> set = new TreeSet<>();
		for(int i = 0; i < n; i++) {
			int a = scanner.nextInt();
			set.add(a);
		}
		g = 2 * set.first();
		for(int k : set) {
			g = gcd(g,k);
		}
		if(g != 1) {
			System.out.println("INF");
			return;
		}
		int[] all = new int[10010];
		Arrays.fill(all, -1);
		for(int k : set) {
			all[k] = 0;
		}
		for(int i = set.first(); i < all.length; i++) {
			if(all[i] != -1) {
				for(int k : set) {
					if(i + k < all.length) {
						all[i+k] = 0;
					}
				}
			}
		}
		int ans = 0;
		for(int i = 1; i < all.length; i++) {
			if(all[i] == -1) {
				ans++;
			}
		}
		System.out.println(ans);
	}
}
