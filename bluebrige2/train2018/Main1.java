package train2018;

public class Main1 {
	public static void main(String[] args) {
		int total = 200;
		int num1 = 1;
		int num2 = 10*num1;
		int ans = 0;
		while(num1 <= 200) {
			int cur = total;
			cur -= num1+num2*2;
			if(cur % 5==0) {
				ans = num1 + num2 + cur / 5;
				break;
			}
			num1++;
			num2 = num1 * 10;
		}
		System.out.println(ans);
	}
}
