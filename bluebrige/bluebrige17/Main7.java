package bluebrige17;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;
public class Main7 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String date = scanner.next();
		String[] arr = date.split("/");
		int first = Integer.parseInt(arr[0]);
		int second = Integer.parseInt(arr[1]);
		int third = Integer.parseInt(arr[2]);
		int[][] arr1 = new int[3][3];
		//如果第二个位置是日 第一个位置就只能是月
		//如果第三个位置是日
		arr1[0][0] = first;
		arr1[0][1] = second;
		arr1[0][2] = third;
		arr1[1][0] = third;
		arr1[1][1] = first;
		arr1[1][2] = second;
		arr1[2][0] = third;
		arr1[2][1] = second;
		arr1[2][2] = first;
		if(arr1[0][1] > 12 || arr1[0][2] > 31) {
			arr1[0][0] = 0;
			arr1[0][1] = 0;
			arr1[0][2] = 0;
		}
		if(arr1[1][1] > 12 || arr1[1][1] == 0) {
			arr1[1][0] = 0;
			arr1[1][1] = 0;
			arr1[1][2] = 0;
		}
		if(arr1[2][2] > 31 || arr1[2][2] == 0 || arr1[2][1] > 12) {
			arr1[2][0] = 0;
			arr1[2][1] = 0;
			arr1[2][2] = 0;
		}
		for(int i = 0; i < 3; i++) {
			if(arr1[i][0] != 0) {
				arr1[i][0] = getYear(arr1[i][0]);
			}
		}
		Arrays.sort(arr1,new Comparator<int[]>() {
			public int compare(int[] a1, int[] a2) {
				if(a1[0] == a2[0] && a1[1] == a2[1]) {
					return a1[2] - a2[2];
				}else if(a1[0] == a2[0]) {
					return a1[1] - a2[1];
				}else {
					return a1[0] - a2[0];
				}
			}
		});
		for(int i = 0; i < 3; i++) {
			if(arr1[i][0] != 0 || arr1[i][1] != 0 || arr1[i][2] != 0) {
				if(i > 0 && arr1[i][0] == arr1[i-1][0] && arr1[i][1] == arr1[i-1][1] && arr1[i][2] == arr1[i-1][2]) {
					continue;
				}
				if(!isValid(arr1[i][0],arr1[i][1],arr1[i][2])) {
					continue;
				}
				String month = arr1[i][1] < 10 ? "0" + Integer.toString(arr1[i][1]) : Integer.toString(arr1[i][1]);
				String day = arr1[i][2] < 10 ? "0" + Integer.toString(arr1[i][2]) : Integer.toString(arr1[i][2]);
				System.out.println(arr1[i][0] + "-" + month + "-" + day);
			}
		}
	}
	public static int getYear(int n) {
		if(n >= 60 && n <= 99) {
			return 1900 + n;
		}else {
			return 2000 + n;
		}
	}
	public static boolean isValid(int year,int month,int day) {
		boolean flag = false;
		if(year % 400 == 0 || (year % 100 != 0 && year % 4 == 0)) {
			flag = true;
		}
		if(flag) {
			if(month == 2 && day > 29) {
				return false;
			}
		}else {
			if(month == 2 && day > 28) {
				return false;
			}
		}
		if((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) {
			return false;
		}
		return true;
	}
}
/*
if(second <= 12 && second >= 1) {
		if(first > 31 && first <= 99) {
			//年/月/日
			arr1[0][0] = getYear(first);
			arr1[0][1] = second;
			arr1[0][2] = third;
		}else if(first > 12 && first <= 31) {
			//年/月/日   日/月/年
			if(third > 31 && third <= 99) {
				arr1[2][0] = getYear(third);
				arr1[2][1] = second;
				arr1[2][2] = first;
			}else {
				arr1[0][0] = getYear(first);
				arr1[0][1] = second;
				arr1[0][1] = third;
				
				arr1[2][0] = getYear(third);
				arr1[2][1] = second;
				arr1[2][2] = first;
			}
		}else {
			// 年月日 月日年 日月年
			
		}
	}else if(second <= 31 && second > 12) {
		// 月/日/年
		arr1[1][0] = getYear(third);
		arr1[1][1] = first;
		arr1[1][2] = second;
		
	}
*/
