package train2021;

public class Main3 {
	static int[] mouth = {0,31,28,31,30,31,30,31,31,30,31,30,31};
	public static void main(String[] args) {
		int yearS = 2001;
		int yearE = 2021;
		int cnt = 0;
		for(int i = yearS; i <= yearE; i++) {
			for(int j = 1; j <= 12; j++) {
				if(isRun(i) && j == 2) {
					mouth[2] = 29;
				}else {
					mouth[2] = 28;
				}
				for(int k = 1; k <= mouth[j];k++) {
					int num = getNum(i,j,k);
					if(isP(num)) {
						cnt++;
					}
				}
			}
		}
		System.out.println(cnt);
	}
	public static int getNum(int year,int mouth,int day) {
		int ans = 0;
		while(year != 0) {
			ans += year % 10;
			year /= 10;
		}
		while(mouth != 0) {
			ans += mouth % 10;
			mouth /= 10;
		}
		while(day != 0) {
			ans += day % 10;
			day /= 10;
		}
		return ans;
	}
	public static boolean isRun(int year) {
		return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
	}
	public static boolean isP(int num) {
		int n = (int)Math.sqrt(num);
		return n * n == num;
	}
}
