package train2017;

public class Main1 {
	public static void main(String[] args) {
		long ans = ('M'-'A'+10)*36*36*36+10*36*36+('N'-'A'+10)*36+('Y'-'A'+10);
		System.out.println(ans);
	}
}
