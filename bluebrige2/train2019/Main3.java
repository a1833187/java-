package train2019;

public class Main3 {
	public static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	public static boolean[][] isVisited = new boolean[8][8];
	public static long ans = 0;
	public static void main(String[] args) {

		for(int i = 0; i < 8; i++) {
			isVisited[i][i] = true;
			dfs(i,i);
			isVisited[i][i] = false;
		}
		System.out.println(ans);
	}
	public static void dfs(int x,int y) {
		if(x == 0 || y == 7) {
			ans++;
			return;
		}
		for(int i = 0; i < 4; i++) {
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];
			if(nx < 0 || nx > 7 || ny < 0 || ny > 7 || isVisited[nx][ny] || nx == ny) {
				continue;
			}
			isVisited[ny][nx] = true;
			isVisited[nx][ny] = true;
			dfs(nx,ny);
			isVisited[ny][nx] = false;
			isVisited[nx][ny] = false;
		}
	}
}
