package train2017;

public class Main2 {
	//黄色为0, 橘色为1
	static int[][][] cache = new int[3][2][10];
	static {
		for(int i = 0; i < 3;i++) {
			cache[i][0][0] = 1;
		}
		cache[2][1][0] = 1;
		
		for(int i = 0; i < 3; i++) {
			cache[i][1][1] = 1;
		}
		cache[0][1][1] = 1;
		
		
	}
	static long ans = 0;
	public static void main(String[] args) {
		
	}
}
