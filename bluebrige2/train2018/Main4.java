package train2018;


//调手表,思路比较简单,就是一个dp
//细节上需要考虑的比较多. k次可能是从前面一点一点加来的,也可能是循环了好几次以后得来的.
import java.util.Scanner;
public class Main4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		long j;
		int[] f = new int[n];
		for(int i = 1; i < n; i++) {
			//1步1步走和k步k步走
			f[i] = i;
			if(i % k == 0) {
				f[i] = i / k;
			}
		}
		for(int i = 1; i < n; i++) {
			//在之前的处理情况下去和k步k步走走多个循环到原来位置哪个更小.
			j = (long)i * k % n;
			f[(int)j] = Math.min(f[(int)j], i);
		}
		int ans = 0;
		for(int i = 1; i < n; i++) {
			f[i] = Math.min(f[i-1], f[(i+n-k)%n])+1;
			ans = Math.max(ans, f[i]);
		}
		System.out.println(ans);
	}
}
