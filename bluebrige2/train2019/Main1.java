package train2019;

public class Main1 {
	public static void main(String[] args) {
		long beg = 2019 * 2019;
		int ans = 10000;
		for(int x = 2020; x <= 10000; x++) {
			for(int y = x + 1; y <= 10000; y++) {
				long cur1 = y*y+beg;
				long cur2 = 2*x*x;
				if(cur1 == cur2) {
					ans = Math.min(ans, x+y);
				}
 			}
		}
		System.out.println(ans);
	}
}
