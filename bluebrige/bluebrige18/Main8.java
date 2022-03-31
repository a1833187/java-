package bluebrige18;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
public class Main8 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int d = scanner.nextInt();
		int k = scanner.nextInt();
		TreeMap<Integer,ArrayList<Integer>> map = new TreeMap<>();
		for(int i = 0; i < n; i++) {
			int time = scanner.nextInt();
			int id = scanner.nextInt();
			if(map.get(id) != null) {
				map.get(id).add(time);
			}else {
				ArrayList<Integer> list = new ArrayList<>();
				list.add(time);
				map.put(id, list);
			}
		}
		
		Set<Integer> set = map.keySet();
		for(int id : set) {
			ArrayList<Integer> l = map.get(id);
			Collections.sort(l);
			boolean flag = false;
			for(int i = 0; i < l.size(); i++) {
				int end = l.get(i) + d;
				int cnt = 0;
				for(int j = i; j < l.size(); j++) {
					if(l.get(j) < end) {
						cnt++;
					}
					if(cnt >= k) {
						System.out.println(id);
						flag = true;
						break;
					}
				}
				if(flag) {
					break;
				}
			}
			
		}
	}
}
