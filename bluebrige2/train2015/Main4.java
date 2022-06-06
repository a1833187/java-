package train2015;

import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.next();
		int n = scanner.nextInt();
		Map<String,Integer> map = new HashMap<>();
		for(int i = 0; i < n; i++) {
			String ss = scanner.next();
			char[] ch = ss.toCharArray();
			Arrays.sort(ch);
			ss = new String(ch);
			map.put(ss,map.getOrDefault(ss, 0)+1);
		}
		int len = s.length();
		int ans = 0;
		for(int i = 0; i +8 <= len; i++) {
			String ss = s.substring(i,i+8);
			char[] ch = ss.toCharArray();
			Arrays.sort(ch);
			ss = new String(ch);
			if(map.containsKey(ss)) {
				ans += map.get(ss);
			}
		}
		System.out.println(ans);
	}
}
