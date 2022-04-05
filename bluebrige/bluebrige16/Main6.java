package bluebrige16;

import java.util.Arrays;
public class Main6 {
	static int count = 0;
	static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	static int[][] judge = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
	static boolean[] isVisited = new boolean[10];
	public static void main(String[] args) {
		int[][] arr = new int[3][4];
		for(int i = 0; i < arr.length;i++) {
			for(int j = 0; j < arr[0].length; j++) {
				arr[i][j] = -10;
			}
		}
		for(int i = 0; i < 10; i++) {
			arr[0][1] = i;
			isVisited[i] = true;
			dfs(arr,0,1);
			isVisited[i] = false;
		}
		System.out.print(count);
		
	}
	public static void dfs(int[][] arr,int x,int y) {
		if(x == 0 && y == 0 || x == 2 && y == 3) {
			return;
		}
		for(int i = 0; i < judge.length; i++) {
			int jx = judge[i][0] + x;
			int jy = judge[i][1] + y;
			if(jx < 0 || jx >= 3 || jy < 0 || jy >= 4 ||(jx == 0 && jy == 0) || (jx == 2 && jy == 3)) {
				continue;
			}
			if(Math.abs(arr[jx][jy]-arr[x][y]) <= 1) {
				return;
			}
		}
		boolean flag = true;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 4; j++) {
				if(i == 0 && j == 0 || i == 2 && j == 3) {
					continue;
				}
				if(arr[i][j] == -10) {
					flag = false;
					break;
				}
			}
		}
		if(flag) {
			count++;
			return;
		}
		for(int i = 0; i < dir.length; i++) {
			int nx = dir[i][0] + x;
			int ny = dir[i][1] + y;
			if(nx < 0 || nx >= 3 || ny < 0 || ny >= 4||(nx == 0 && ny == 0) || (nx == 2 && ny == 3)) {
				continue;
			}
			for(int j = 0; j < 10; j++) {
				if(!isVisited[j]) {
					isVisited[j] = true;
					arr[nx][ny] = j;
					dfs(arr,nx,ny);
					isVisited[j] = false;
				}
			}
		}
	}
}
