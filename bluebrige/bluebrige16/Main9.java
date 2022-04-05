package bluebrige16;

import java.util.Scanner;
public class Main9 {
	static int[][][] cache = new int[1000][2][2];
	static int[] arr;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		arr = new int[3];
		int[] game = new int[5];
		for(int i = 0; i < 3; i++) {
			arr[i] = scanner.nextInt();
			min = Math.min(min, arr[i]);
		}
		for(int i = 0; i < 5;i++) {
			game[i] = scanner.nextInt();
			int ans = dfs(5,0,0);
			if(ans == -1) {
				System.out.print("- ");
			}else if(ans == 1) {
				System.out.print("0 ");
			}else if(ans  == 2) {
				System.out.print("+ ");
			}
		}
	}
	public static int dfs(int rest,int have,int other) {
		if(rest < min) {
			if(have % 2 != 0 && other % 2 == 0) {
				return 2;
			}else if(have % 2 == 0 && other % 2 == 0) {
				return 1;
			}else if(have % 2 != 0 && other % 2 != 0) {
				return 1;
			}
			return -1;
		}
		boolean equalFlag = false;
		for(int a : arr) {
			if(a > rest) {
				continue;
			}
			int result;
			if(cache[rest-a][other % 2][(have+a)%2] != 0) {
				result = cache[rest-a][other % 2][(have + a) % 2];
			}else {
				//这里交换have 和 other 和最开始的判断条件共同实现了 轮流拿球的效果。
				result = dfs(rest - a,other,have + a);
				cache[rest-a][other % 2][(have + a) % 2] = result;
			}
			//当程序走到这时,说明一轮博弈的试探已经结束,result
			//中存储的结果分为两种情况:一种是最后一次是我取,这时result
			//中存储的是敌人是否会赢;当最后一次是敌取,这时result
			//中存储的是我是否会赢;容易证明最后一次是敌取时我和敌取球的次数是相同的
			//这时候因为会遍历所有的情况,所以我只需要按照敌人那样取球我就会赢。
			//综上 我们只需要求出本次尝试时敌人是否会赢,如果敌人输了,那我们就赢了;
			//如果敌人赢了,我们可以在之后
			if(result == -1) {
				return 2;
			}
			//程序走到这说明本次试探无法让我方获胜,所以退而求其次看是否能达到平局
			//然后继续新的试探
			if(result == 1) {
				equalFlag = true;
			}
		}
		//当程序走到这说明我方无法获胜,所以要判断前面多次尝试的结果中是否存在达到平局的效果
		if(equalFlag) {
			return 1;
		}else {
			return -1;
		}
	}
}
