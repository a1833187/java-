package bluebrige18;

import java.util.Scanner;
import java.util.Arrays;

public class Main9 {
	static boolean[][] isVisited;
	static int countOld = 0;
	static int countNew = 0;
	static int n;
	static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		n = scanner.nextInt();
		char[][] oldMap =  new char[n][n];
		char[][] newMap = new char[n][n];
		isVisited = new boolean[n][n];
		for(int i = 0;i < n; i++) {
			String str = scanner.next();
			for(int j = 0; j < n; j++) {
				oldMap[i][j] = str.charAt(j);
				newMap[i][j] = oldMap[i][j];
			}
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(newMap[i][j] == '#') {
				for(int k = 0; k < 4; k++) {
					int nx = i + dir[k][0];
					int ny = j + dir[k][1];
					if(nx >= 0 && nx < n && ny >= 0 && ny < n && newMap[nx][ny] == '.') {
						newMap[i][j] = '*';
						break;
					}
				}
				}
			}
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(oldMap[i][j] == '#' && !isVisited[i][j]) {
					dfs(oldMap,i,j);
					countOld++;
				}
			}
		}
		isVisited = new boolean[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(newMap[i][j] == '#' && !isVisited[i][j]) {
					dfs(newMap,i,j);
					countNew++;
				}
			}
		}
		System.out.println(countOld - countNew);
	}
	public static void dfs(char[][] map,int x,int y) {
		if(x < 0 || x > n || y < 0 || y > n || isVisited[x][y] || map[x][y] != '#') {
			return;
		}
		isVisited[x][y] = true;
		for(int i = 0; i < 4; i++) {
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];
			dfs(map,nx,ny);
		}
	}
}
