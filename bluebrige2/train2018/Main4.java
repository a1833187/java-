package train2018;


//���ֱ�,˼·�Ƚϼ�,����һ��dp
//ϸ������Ҫ���ǵıȽ϶�. k�ο����Ǵ�ǰ��һ��һ�������,Ҳ������ѭ���˺ü����Ժ������.
import java.util.Scanner;
public class Main4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		long j;
		int[] f = new int[n];
		for(int i = 1; i < n; i++) {
			//1��1���ߺ�k��k����
			f[i] = i;
			if(i % k == 0) {
				f[i] = i / k;
			}
		}
		for(int i = 1; i < n; i++) {
			//��֮ǰ�Ĵ��������ȥ��k��k�����߶��ѭ����ԭ��λ���ĸ���С.
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
