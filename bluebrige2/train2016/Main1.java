package train2016;

public class Main1 {
	public static void main(String[] args) {
		int a = 1;
		while(true) {
			if((a*97-1)%127 == 0) {
				break;
			}
			a++;
		}
		int b = (a*97-1)/127;
		System.out.println(a + " " + b);
		System.out.println(a+b);
	}
}
