package bluebrige19;

import java.util.LinkedList;
import java.util.Queue;

public class Main5 {
	static int[][] map;
	static int[][] dir = {{1,0},{0,-1},{0,1},{-1,0}};
	static int m;
	static int n;
	static class Path{
		int x;
		int y;
		char[] pat = {'D','L','R','U'};
		String path = "";
		Path(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) {
		
	}
	public static String bfs() {
		Queue<Path> queue = new LinkedList<>();
		queue.offer(new Path(0,0));
		while(!queue.isEmpty()) {
			Path p = queue.poll();
			if(p.x == m-1 && p.y == n-1) {
				break;
			}
			for(int i = 0; i < 4;i++) {
				int px = p.x + dir[i][0];
				int py = p.y + dir[i][1];
				if(px >= 0 && px < m && py >= 0 && py < n && map[px][py] != 1) {
					Path pp = new Path(px,py);
					pp.path += p.path + pp.pat[i];
					queue.offer(pp);
				}
			}
		}
		return queue.peek().path;
	}
}
