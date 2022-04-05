package bluebrige16;

import java.util.Scanner;
public class Main8 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for(int i = 0; i * i <= n; i++) {
			for(int j = i; j * j <= n; j++) {
				for(int k = j; k * k <= n; k++) {
					for(int l = k; l * l <= n; l++) {
						if(i*i + j*j + k*k + l*l == n) {
							System.out.print(i + " " + j + " " + k + " " + l);
							return;
						}
					}
				}
			}
		}
	}
}
