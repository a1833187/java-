package bluebrige18;

public class Main3 {
	public static void main(String[] args) {
		int[] arr1 = {2,3};
		int[] arr2 = {2,3};
		for(int i = 1; i < 123456; i++) {
			arr1 = func(arr1,arr2);
		}
		System.out.println(arr1[0]);
		System.out.println(arr1[1]);
	}
	public static int[] func(int[] arr1,int[] arr2) {
		int[] res = new int[2];
		res[0] = arr1[0]*arr2[0] - arr1[1]*arr2[1];
		res[1] = arr1[0]*arr2[1] + arr1[1]*arr2[0];
		return res;
	}
}
