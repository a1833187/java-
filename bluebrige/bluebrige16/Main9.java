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
				//���ｻ��have �� other ���ʼ���ж�������ͬʵ���� ���������Ч����
				result = dfs(rest - a,other,have + a);
				cache[rest-a][other % 2][(have + a) % 2] = result;
			}
			//�������ߵ���ʱ,˵��һ�ֲ��ĵ���̽�Ѿ�����,result
			//�д洢�Ľ����Ϊ�������:һ�������һ������ȡ,��ʱresult
			//�д洢���ǵ����Ƿ��Ӯ;�����һ���ǵ�ȡ,��ʱresult
			//�д洢�������Ƿ��Ӯ;����֤�����һ���ǵ�ȡʱ�Һ͵�ȡ��Ĵ�������ͬ��
			//��ʱ����Ϊ��������е����,������ֻ��Ҫ���յ�������ȡ���Ҿͻ�Ӯ��
			//���� ����ֻ��Ҫ������γ���ʱ�����Ƿ��Ӯ,�����������,�����Ǿ�Ӯ��;
			//�������Ӯ��,���ǿ�����֮��
			if(result == -1) {
				return 2;
			}
			//�����ߵ���˵��������̽�޷����ҷ���ʤ,�����˶�����ο��Ƿ��ܴﵽƽ��
			//Ȼ������µ���̽
			if(result == 1) {
				equalFlag = true;
			}
		}
		//�������ߵ���˵���ҷ��޷���ʤ,����Ҫ�ж�ǰ���γ��ԵĽ�����Ƿ���ڴﵽƽ�ֵ�Ч��
		if(equalFlag) {
			return 1;
		}else {
			return -1;
		}
	}
}
