package train2019;

import java.util.Scanner;

public class Main6 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.next();
		String t = scanner.next();
		int m = s.length();
		int n = t.length();
		int[][] f = new int[m+1][n+1];
		for(int i = 1;i <= m; i++) {
			for(int j = 1; j <= Math.min(n,i);j++) {
				if(s.charAt(i-1) == t.charAt(j-1)) {
					f[i][j] = f[i-1][j-1];
				}else {
					//������Ҫ��������һ��.�����ڵ�ʱ��,���ܺ�f[i-1][j]���бȽ�
					if(i == j) {
						f[i][j] = f[i-1][j-1]+1;
					}else {
						f[i][j] = Math.min(f[i-1][j-1]+1, f[i-1][j]);
					}
				}
			}
		}
		System.out.println(f[m][n]);
	}
}
