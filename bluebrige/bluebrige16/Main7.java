package bluebrige16;

import java.util.HashSet;
public class Main7 {
	public static int count = 0;
	public static int[][] arr;
	public static boolean[][] isVisited;
	public static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	public static HashSet<String> set = new HashSet<>();
	public static void main(String[] args) {
		arr = new int[3][4];
		isVisited = new boolean[3][4];
		for(int i = 0; i < 3;i++) {
			for(int j = 0; j < 4; j++) {
				if(!isVisited[i][j]) {
					isVisited[i][j] = true;
					dfs(i,j,1);
					isVisited[i][j] = false;
				}
			}
		}
		System.out.println(set.size());
		for(String s : set) {
			System.out.println(s);
		}
		System.out.print(count);
	}
	public static void dfs(int x,int y,int countTmp){
		if(countTmp == 5) {
			String s = new String();
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 4; j++) {
					if(isVisited[i][j]) {
						s += i + " " + j + ",";
					}
				}
			}
			set.add(s);
			count++;
			return;
		}
		for(int i = 0; i < dir.length; i++) {
			int nx = dir[i][0] + x;
			int ny = dir[i][1] + y;
			if(nx < 0 || nx >= 3 || ny < 0 || ny >= 4 || isVisited[nx][ny]) {
				continue;
			}
			isVisited[nx][ny] = true;
			dfs(nx,ny,countTmp+1);
			isVisited[nx][ny] = false;
		}
		
	}
	
}
