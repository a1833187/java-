package train2019;

public class Main4 {
	public static void main(String[] args) {
		int ans = 0;
		for(int i = 1;;i++) {
			int sum = 0;
			for(int j = 1; j <= i; j++) {
				if(i % j == 0) {
					sum++;
				}
			}
			if(sum == 100) {
				ans = i;
				break;
			}
		}
		System.out.println(ans);
	}
}
