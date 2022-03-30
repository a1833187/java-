package bluebrige19;

import java.util.Scanner;
import java.util.ArrayList;
public class Main8 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int k = scanner.nextInt();
		String s = scanner.nextLine();
		String str = scanner.nextLine();
		String a = "Alice";
		String b = "Bob";
		ArrayList<int[]> A = new ArrayList<>();
		ArrayList<int[]> B = new ArrayList<>();
		for(int i = 0; i < str.length(); i++) {
			if((i+4) < str.length() && a.equals(str.substring(i,i+5))) {
				int[] arr = {i,i+4};
				A.add(arr);
			}
			if((i+2) < str.length() && b.equals(str.substring(i,i+3))){
				int[] arr = {i,i+2};
				B.add(arr);
			}
		}
		long cnt = 0;
		for(int i = 0; i < A.size(); i++) {
			for(int j = 0; j < B.size(); j++) {
				int[] arr1 = A.get(i);
				int[] arr2 = B.get(j);
				if(arr1[1] - arr2[0] < 0 && arr2[0] - arr1[1] -1 <= k) {
					cnt++;
				}
				if(arr2[1] - arr1[0] < 0 && arr1[0] - arr2[1] - 1 <= k) {
					cnt++;
				}
			}
		}
		System.out.print(cnt);
	}
}
