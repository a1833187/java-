package train2021;

public class Main2 {
	static final int MAX = 20210605;
	static int cnt = 0;
	public static void main(String[] args) {
		for(int i = 2; i<= MAX; i++) {
			boolean flag = true;
			if(isSu(i)) {
				int cur = i;
				while(cur != 0) {
					if(!isSu(cur%10)) {
						flag = false;
						break;
					}
					cur/=10;
				}
			}else {
				flag = false;
			}
			if(flag) {
				System.out.println(i);
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	public static boolean isSu(int n) {
		if(n < 2) {
			return false;
		}
		if(n == 2) {
			return true;
		}
		for(int i = 2; i*i<=n;i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
