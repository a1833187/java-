package bluebrige19;

import java.util.Scanner;
public class Main6 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int ans = 0;
		for(int i = 1; i <= n; i++) {
			if(isValid(i)) {
				ans += i;
			}
		}
		System.out.print(ans);
	}
	public static boolean isValid(int n) {
		while(n != 0) {
			int k = n % 10;
			if(k == 0 || k == 2 || k == 1 || k == 9) {
				return true;
			}
			n = n / 10;
		}
		return false;
	}
}
