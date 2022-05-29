package train2018;

import java.util.Scanner;
public class Main5 {
	static int MOD = 1000000007;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		char[][] ch = new char[n][m];
		int[][][] f = new int[n][m][m];
		for(int i = 0; i < n; i++) {
			String s = scanner.next();
			for(int j = 0; j < m; j++) {
				ch[i][j] = s.charAt(j);
			}
		}
		dfs(n-1,0,m-1,f,ch);
		System.out.println(f[n-1][0][m-1]);
	}
	public static int dfs(int step,int l,int r,int[][][] f,char[][] ch) {
		if(step < 0) {
			return 1;
		}
		if(f[step][l][r] != 0) {
			return f[step][l][r];
		}
		int ans = 1;
		for(int i = l;i <= r; i++) {
			if(ch[step][i] == '.') {
				for(int j = i; j <= r; j++) {
					if(ch[step][j] == 'X') {
						break;
					}
					ans =(ans + dfs(step-1,i,j,f,ch))% MOD;
				}
			}
		}
		f[step][l][r] = ans;
		return ans;
	}
}
