package train2015;

import java.util.HashSet;
import java.util.Set;

public class Main2 {
	static int[] dict = {2,5,9,11,16,17,19,21,22,24,26,30,31,33,35,36,41,50,52};
	static boolean[] isV = new boolean[19];
	static boolean flag = false;
	public static boolean judge(int sx,int sy,int d,int[][] map) {
		int m = map.length;
		//越界
		if(sx + d > m || sy + d > m) {
			return false;
		}
		//覆盖
		for(int i = sx;i < sx + d; i++) {
			for(int j = sy; j < sy + d; j++) {
				if(map[i][j] != 0) {
					return false;
				}
			}
		}
		return true;
	}
	public static boolean paint(int sx,int sy,int d,int[][] map) {
		int m = map.length;
		//越界
		if(sx + d > m || sy + d > m) {
			return false;
		}
		//覆盖
		for(int i = sx;i < sx + d; i++) {
			for(int j = sy; j < sy + d; j++) {
				if(map[i][j] != 0) {
					return false;
				}
			}
		}
		//涂色
		for(int i = sx;i < sx + d; i++) {
			for(int j = sy; j < sy + d; j++) {
				map[i][j] = d;
			}
		}
		return true;
	}
	public static void getZero(int sx,int sy,int d,int[][] map) {
		int m = map.length;
		//回溯恢复成0
		for(int i = sx; i < sx + d; i++) {
			for(int j = sy; j < sy + d; j++) {
				map[i][j] = 0;
			}
		}
	}
	public static int[] getC(int[][] map) {
		int m = map.length;
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 0) {
					return new int[] {i,j};
				}
			}
		}
		return null;
	}
	public static void main(String[] args) {
		//47 46 61
		//边长为154
		int m = 154;
		int[][] map = new int[m][m];
		paint(0,0,47,map);
		paint(0,47,46,map);
		paint(0,93,61,map);
		dfs(map);
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < m ;j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		Set<Integer> set = new HashSet<>();
		for(int i = 0; i < m; i++) {
			set.add(map[m-1][i]);
		}
		for(int num : set) {
			System.out.print(num + " ");
		}
	}
	public static void dfs(int[][] map) {
		int[] q = getC(map);
		if(q == null) {
			flag = true;
			return;
		}
		int x = q[0],y = q[1];
		for(int i = 0; i < 19; i++) {
			int d = dict[i];
			if(isV[i]) {
				continue;
			}
			if(paint(x,y,d,map)) {
				isV[i] = true;
				dfs(map);
				if(flag) {
					return;
				}
				isV[i] = false;
				getZero(x,y,d,map);
			}
		}
	}
	
}
