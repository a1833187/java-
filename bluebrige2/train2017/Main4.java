package train2017;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//并查集可以判断一个无向图是否有环.但不能把这个环给描述出来.
public class Main4 {
	static int[] d;
	static int n;
	static Map<Integer,List<Integer>> map;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		map = new HashMap<>();
		int n = scanner.nextInt();
		d = new int[n+1];
		for(int i = 0; i < n; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			if(map.containsKey(a)) {
				map.get(a).add(b);
			}else {
				List<Integer> list = new ArrayList<>();
				list.add(b);
				map.put(a, list);
			}
			if(map.containsKey(b)) {
				map.get(b).add(a);
			}else {
				List<Integer> list = new ArrayList<>();
				list.add(a);
				map.put(b, list);
			}
			d[a]++;
			d[b]++;
		}
		for(int i = 1; i <= n; i++) {
			if(d[i] == 1) {
				int tmp = i;
				while(d[tmp] == 1) {
					int cur = map.get(tmp).get(0);
					d[cur]--;
					tmp = cur;
				}
			}
		}
		for(int i = 1; i <= n;i++) {
			if(i != n) {
				if(d[i] > 1) {
					System.out.print(i + " ");
				}
			}else {
				System.out.print(i);
			}
		}
		System.out.println();
		
	}
	
}
