package bluebrige18;

public class Main2 {
	public static void main(String[] args) {
		int cnt = 0;
		int num = 1000;
		for(int i = 1;i <= num; i++) {
			for(int j = 1; j <= num; j++) {
				if(i*i+j*j <= num * num) {
					cnt++;
				}
			}
		}
		System.out.print(cnt*4);
	}
}
