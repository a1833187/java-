package bluebrige19;

public class Main3 {
	public static void main(String[] args) {
		int n1 = 1;
		int n2 = 1;
		int n3 = 1;
		int n4 = 0;
		int k = 3;
		while(k != 20190324) {
			n4 = n1 + n2 + n3;
			n1 = n2;
			n2 = n3;
			n3 = n4;
			k++;
		}
		System.out.print(n4);
	}
}
