package bluebrige18;

import java.util.Scanner;
public class Main7 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		if(x == 0 && y == 0) {
			System.out.print(0);
			return;
		}
		long k = 0;
		if(Math.abs(x) <= Math.abs(y) && y < 0) {
			k = Math.abs(y);
		}else {
			k = Math.max(Math.abs(x),Math.abs(y))-1;
		}
		long ans1 = (1+2*k)*(2*k);
		long ans = 0;
		if(y == -1*k && x <= k) {
			ans = ans1 + Math.abs(x-k);
		}else if(x == -1 * Math.abs(k+1)) {
			ans = ans1 + 2*k+1+Math.abs(y+k);
		}else if(y == k + 1) {
			ans = ans1 + 4*k+2 + Math.abs(x+k+1);
		}else if(x == k + 1) {
			ans = ans1 + 6*k+4 + Math.abs(k+1-y); 
		}
		System.out.print(ans);
		
		
	}
}
