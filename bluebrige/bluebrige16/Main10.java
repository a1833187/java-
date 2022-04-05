package bluebrige16;

import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;
public class Main10 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}
		int[] ans = new int[n];
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i = 0; i < n; i++) {
			if(map.get(arr[i]) != null) {
				ans[i] = getType(arr,map.get(arr[i])+1,i);
			}else {
				ans[i] = -1 * arr[i];
			}
			map.put(arr[i], i);
		}
		for(int i = 0; i < n; i++) {
			if(i != n - 1) {
				System.out.print(ans[i] + " ");
			}else {
				System.out.print(ans[i]);
			}
		}
		
	}
	public static int getType(int[] arr,int start,int end) {
		HashSet<Integer> set = new HashSet<>();
		for(int i = start; i < end; i++) {
			set.add(arr[i]);
		}
		return set.size();
	}
}
