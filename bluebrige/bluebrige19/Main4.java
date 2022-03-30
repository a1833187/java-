package bluebrige19;

public class Main4 {
	public static void main(String[] args) {
		int cnt = 0;
		int cnt1 = 0;
		int num = 2019;
		for(int i = 1; i < num; i++) {
			if(isValid(i)) {
				for(int j = 1; j < num; j++) {
					if(isValid(j) && j != i){
						int k = num - i - j;
						if(isValid(k) && k != i && k !=j && k > 0) {
						cnt++;
						}
					}
				}
			}
		}
		for(int i = 1; i < num; i++) {
			if(isValid(i)) {
				for(int j = 1; j < num; j++) {
					if(isValid(j)) {
						int k = num - i - j;
						if(isValid(k) && isTrue(i,j,k) && k > 0) {
							cnt1++;
						}
					}
				}
			}
		}
			System.out.println(cnt);
			System.out.println(cnt1);
			System.out.print(cnt / 6 + cnt1 / 3);
		
	}
	public static boolean isTrue(int n1,int n2,int n3) {
		if(n1 == n2 && n1 != n3) {
			return true;
		}
		if(n1 == n3 && n1 != n2) {
			return true;
		}
		if(n2 == n3 && n2 != n1) {
			return true;
		}
		return false;
	}
	public static boolean isValid(int n) {
		while(n != 0) {
			int k = n % 10;
			if(k == 2 || k == 4) {
				return false;
			}
			n = n / 10;
		}
		return true;
	}
}
