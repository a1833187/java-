package train2016;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main2 {
	static long ans = 0;
	static int[] arr = {0,1,2,3,4,5,6,7,8,9};
	public static void main(String[] args) {
		dfs(0);
		System.out.println(ans);
	}
	public static void dfs(int index) {
		if(index == 10) {
			ans++;
			return;
		}
		for(int i = index; i < 10; i++) {
			swap(i,index);
			dfs(index+1);
			swap(i,index);
		}
	}
	public static void swap(int i,int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
