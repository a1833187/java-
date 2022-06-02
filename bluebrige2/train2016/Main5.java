package train2016;

import java.util.Scanner;
public class Main5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[][] zb = new int[n][2];
		int minX = Integer.MAX_VALUE,maxX = Integer.MIN_VALUE;
		int minY = Integer.MAX_VALUE,maxY = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++) {
			zb[i][0] = scanner.nextInt();
			zb[i][1] = scanner.nextInt();
			minX = Math.min(minX, zb[i][0]);
			maxX = Math.max(maxX, zb[i][0]);
			minY = Math.min(minY, zb[i][1]);
			maxY = Math.max(maxY, zb[i][1]);
		}
		long ans = 0;
		for(int x = minX; x < maxX; x++) {
			for(int y = minY; y < maxY; y++) {
				if(isValid(zb,x,y) && isValid(zb,x+1,y) && isValid(zb,x,y+1) && isValid(zb,x+1,y+1)) {
					ans++;
				}
			}
		}
		System.out.println(ans);
	}
	public static boolean isValid(int[][] zb,int x,int y) {
		int i = 0,j = zb.length- 1;
		int cnt = 0;
		for(; i < zb.length;i++) {
			int tmpX = 0;
			if(Math.min(zb[i][1], zb[j][1]) < y && Math.max(zb[i][1], zb[j][1]) > y) {
				if(zb[i][0] - zb[j][0] == 0) {
					tmpX = zb[i][0];
				}else if(zb[i][1] - zb[j][1] == 0) {
					tmpX = Math.min(zb[i][0], zb[j][0]);
				}else {
					int k = (zb[i][1] - zb[j][1])/(zb[i][0]-zb[j][0]);
					tmpX = (y-zb[i][1])/k+zb[i][0];
				}
				if(tmpX <= x) {
					cnt++;
				}
			}
			j = i;
		}
		return cnt % 2 != 0;
	}
}
