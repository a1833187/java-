package train2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main6 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s1 = scanner.next();
		String s2 = scanner.next();
		List<String> list1 = new ArrayList<>();
		List<String> list2 = new ArrayList<>();
		int n = s1.length();
		int l = 0,r = 0;
		while(r < n) {
			if(s1.charAt(r) >= 'A' && s1.charAt(r) <= 'Z') {
				r++;
			}
			while(r < n && (s1.charAt(r) >= 'a' && s1.charAt(r) <= 'z')) {
				r++;
			}
			list1.add(s1.substring(l,r));
			l = r;
		}
		n = s2.length();
		l = 0;r=0;
		while(r < n) {
			if(s2.charAt(r) >= 'A' && s2.charAt(r) <= 'Z') {
				r++;
			}
			while(r < n && (s2.charAt(r) >= 'a' && s2.charAt(r) <= 'z')) {
				r++;
			}
			list2.add(s2.substring(l,r));
			l = r;
		}
		int m = list1.size();
		n = list2.size();
		int[][] f = new int[m+1][n+1];
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if(list1.get(i-1).equals(list2.get(j-1))) {
					f[i][j] = f[i-1][j-1] + 1;
				}else {
					f[i][j] = Math.max(f[i-1][j], f[i][j-1]);
				}
			}
		}
		System.out.println(f[m][n]);
	}
}
