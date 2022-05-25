package train2020;


public class Main2 {
	public static void main(String[] args) {
		long ans = 0;
		for(int i = -2020;i <= 4040; i++) {
			for(int j = -2020;j<=4020;j++) {
				boolean flag1 = isValid(i,j,0,0,2020);
				boolean flag2 = isValid(i,j,2020,11,2020);
				boolean flag3 = isValid(i,j,11,14,2020);
				boolean flag4 = isValid(i,j,2000,2000,2020);
				if(flag1 || flag2 || flag3 || flag4) {
					ans++;
				}
			}
		}
		System.out.println(ans);
	}
	public static boolean isValid(int x,int y,int x1,int y1,int key) {
		long factor = Math.abs(x-x1)+Math.abs(y-y1);
		return (factor <= key);
	}
}
