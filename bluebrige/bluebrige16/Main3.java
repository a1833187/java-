package bluebrige16;

public class Main3 {
	public static void main(String[] args) {
		long sum = 0;
		for(int a = 1; a <= 9; a++) {
			for(int b = 1; b <= 9; b++) {
				for(int c = 1; c <= 9; c++) {
					for(int d = 111; d <= 999; d++) {
						for(int e = 111; e <= 999; e++) {
							if(b % c != 0 && d % e != 0) {
								if(e % c == 0) {
									if((b*(e / c)+d) % e == 0 && a + (b*(e / c)+d) / e == 10){
										sum++;
									}
								}
							}else if(b % c == 0 && d % e == 0) {
								if(a + b/c + d/e == 10) {
									sum++;
								}
							}
						}
					}
				}
			}
		}
		System.out.print(sum);
	}
}
