package train2019;

public class Main5 {
	//要减去两条不符合的路径:   0,0 --> 1,0 ---> 0,0    0,0 --> 0,1 ---> 0,0
	public static int ans = 0;
	public static boolean[][] isVisited = new boolean[6][6];
	public static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) {
		dfs(0,0,0);
		System.out.println(ans);
	}
	public static void dfs(int x,int y,int step) {
		if(step > 12) {
			return;
		}
		if(x == 0 && y== 0 && step != 0) {
			ans++;
			return;
		}
		for(int i = 0; i < 4; i++) {
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];
			if(nx < 0 || nx > 5 || ny < 0 || ny > 5 || isVisited[nx][ny]) {
				continue;
			}
			isVisited[nx][ny] = true;
			dfs(nx,ny,step+1);
			isVisited[nx][ny] = false;
		}
	}
}
