package train2017;

import java.util.HashSet;
import java.util.Set;

public class Main3 {
	static int count = 0;
	static Set<String> set;
	static int m = 3;
	static int n = 10;
	static int[][] isVisited = new int[m+1][n+1];
	public static void main(String[] args) {
		set = new HashSet<>();
		dfs(0);
		System.out.println(set.size());
	}
	public static void dfs(int count) {
		
		for(int i = 1; i < m; i++) {
			for(int j = 1; j < n; j++) {
				if(isVisited[i][j] != 0 && isVisited[i][j] == isVisited[i][j+1] 
						&& isVisited[i][j] == isVisited[i+1][j] && isVisited[i][j+1] == isVisited[i+1][j]) {
					return;
				}
			}
		}
		if(count == m * n) {
			String s = "";
			for(int i = 1; i <= m; i++) {
				for(int j = 1; j <= n; j++) {
					s += "" + isVisited[i][j];
				}
			}
			set.add(s);
		}
		if(count > m * n) {
			return;
		}
		boolean flag = false;
		int x = 1, y = 1;
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if(isVisited[i][j] == 0) {
					flag = true;
					x = i;
					y = j;
					break;
				}
			}
			if(flag) {
				break;
			}
		}
		if(!flag) {
			return;
		}
		if(y + 1 <= n && isVisited[x][y+1] == 0) {
			isVisited[x][y] = 1;
			isVisited[x][y+1] = 1;
			dfs(count+2);
			isVisited[x][y] = 2;
			isVisited[x][y+1] = 2;
			dfs(count+2);
			isVisited[x][y] = 0;
			isVisited[x][y+1] = 0;
		}
		if(x + 1 <= m && isVisited[x+1][y] == 0) {
			isVisited[x][y] = 1;
			isVisited[x+1][y] = 1;
			dfs(count+2);
			isVisited[x][y] = 2;
			isVisited[x+1][y] = 2;
			dfs(count+2);
			isVisited[x][y] = 0;
			isVisited[x+1][y] = 0;
		}
	}
}
