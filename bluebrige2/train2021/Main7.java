package train2021;

import java.util.Scanner;
public class Main7 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for(int i = 0; i < n; i++) {
			long left = scanner.nextLong();
			long right = scanner.nextLong();
			long[] k = getN(left,right);
			long n1 = k[0];
			long n2 = k[1];
			//要包含
			long curS = (left+n1-(n1*(n1-1))/2)*((n1*n1+n1)/2-left+1)/2;
			if(n1 == n2) {
				System.out.println(curS);
			}else {
				//不包含
				long curE = (1+right+n2-(n2*(n2-1))/2)*((n2*n2+n2)/2-right)/2;
				if(n1 + 1 == n2) {
					System.out.println(curS+curE);
				}else {
					long nt = n1 + 1;
					long curZ1 = getNum(n1);
					long curZ2 = getNum(n2);
					long ans = curZ2-curE-(curZ1-curS);
					System.out.println(ans);
				}
			}
			
		}
	}
	public static long getNum(long k) {
		if(k % 2 == 0) {
			long n = k / 2;
			long ans = (k+1)*(n*n+n)/2-(n*(n+1)*(2*n+1))/6;
			return ans * 2;
		}else {
			long n = k / 2;
			long ans = (k+1)*(n*n+n)/2-(n*(n+1)*(2*n+1))/6;
			return ans + (n+1)*(k-n);
		}
	}
	public static long[] getN(long left,long right) {
		long n1 = 1;
		while(true) {
			long l = n1 * (n1-1)/2;
			long r = n1 *(n1+1)/2;
			if(left > l && left <= r) {
				break;
			}
			n1++;
		}
		long n2 = n1;
		while(true) {
			long l = n2 * (n2-1)/2;
			long r = n2 *(n2+1)/2;
			if(right > l && right <= r) {
				break;
			}
			n2++;
		}
		return new long[] {n1,n2};
	}
}
