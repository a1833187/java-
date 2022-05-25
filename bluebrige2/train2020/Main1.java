package train2020;

public class Main1 {
	public static void main(String[] args) {
		int ans = 0;
		for(int i = 1; i <= 2020; i++) {
			if(isContains2(i)) {
				ans++;
			}
		}
		System.out.println(ans);
	}
	public static boolean isContains2(int n) {
		while(n != 0) {
			if(n % 10 == 2) {
				return true;
			}
			n/=10;
		}
		return false;
	}
}
