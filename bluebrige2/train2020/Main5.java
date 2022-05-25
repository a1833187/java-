package train2020;

public class Main5 {
	public static long cnt = 0;
	public static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	public static boolean[][] isVisited = new boolean[4][4];
	public static void main(String[] args) {
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				isVisited[i][j] = true;
				dfs(1,i,j);
				isVisited[i][j] = false;
			}
		}
		System.out.println(cnt);
	}
	public static void dfs(int index,int x,int y) {
		if(index == 16) {
			cnt++;
		}
		for(int i = 0; i < 4; i++) {
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];
			if(nx < 0 || nx >= 4 || ny < 0 || ny >= 4 || isVisited[nx][ny]) {
				continue;
			}
			isVisited[nx][ny] = true;
			dfs(index+1,nx,ny);
			isVisited[nx][ny] = false;
		}
	}
}
