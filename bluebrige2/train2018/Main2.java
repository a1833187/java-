package train2018;

public class Main2 {
	public static void main(String[] args) {
		int[] f = new int[31];
		f[0] = 1;
		f[1] = 2;
		for(int i = 2; i <= 30; i++) {
			f[i] = f[i-1]+f[i-2];
		}
		System.out.println(f[30]);
	}
}
