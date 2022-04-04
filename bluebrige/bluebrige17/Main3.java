package bluebrige17;

public class Main3 {
	public static void main(String[] args) {
		int[][] a = new int[29][29];
		double[][] b = new double[29][29];
		b[0][0] = a[0][0];
		for(int i = 1; i < 29; i++) {
			b[i][0] = b[i-1][0] + a[i][0];
			b[i][i] = b[i-1][i-1] + a[i][i];
		}
		for(int i = 2; i < 29; i++) {
			for(int j = 1; j < i; j++) {
				b[i][j] = (b[i-1][j-1] + b[i-1][j]) / 2 + a[i][j];
			}
		}
		double max = 0;
		for(int i = 0; i < 29; i++) {
			max = Math.max(max, b[29][i]);
		}
		
	}
}
