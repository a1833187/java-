package bluebrige16;

public class Main1 {
	public static void main(String[] args) {
		long sum = 0;
		for(int k = 1; k <= 100; k++) {
			sum += 0.5*(k+k*k);
		}
		System.out.print(sum);
	}
}
