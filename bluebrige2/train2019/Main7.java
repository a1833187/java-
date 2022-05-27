package train2019;

import java.util.Scanner;

// ��������K������   dp(��,���dp̫����.�÷������ۺܶ������)
// K������ ָ����һ�������� ��k-1��ת�۵�
public class Main7 {
	public static int MOD = 123456;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int[][] f = new int[n+1][k+1];
		f[1][1] = 1;
		f[2][1] = 2;
		for(int i = 3; i <= n; i++) {
			for(int j = 1; j <= k && j <= i; j++) {
				f[i][j] = (f[i][j]+f[i-1][j]*j)%MOD;
				f[i][j] = (f[i][j]+f[i-1][j-1]*2)%MOD;
				if(j > 1) {
					f[i][j] = (f[i][j]+f[i-1][j-2]*(i-j))%MOD;
				}
			}
		}
		System.out.println(f[n][k]);
	}
}
