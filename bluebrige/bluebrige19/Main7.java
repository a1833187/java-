package bluebrige19;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *   ��Ϊ��һ����ÿ��ʱ�̶����ڶ�һ������������Ҳ����˵ʱ���ǲ������ġ�����map������Ϊ�����꣬Ȼ���Ӧ�洢����������������ʱ�̡�
 *   �������ж�ÿ�������굽Tʱ�̻᲻�ᱻ�洢�����ȼ���
 * @author qiu
 *
 */
public class Main7 {
	static Scanner in = new Scanner(System.in);
	static int n, m, t;
	static Map<Integer, ArrayList<Integer>> map = new TreeMap<Integer, ArrayList<Integer>>();
	static int result;

	public static void main(String[] args) {
		n = in.nextInt();
		m = in.nextInt();
		t = in.nextInt();
		for (int i = 1; i <= m; ++i) {
			int time = in.nextInt();
			int id = in.nextInt();
			if (map.containsKey(id)) {
				map.get(id).add(time);
			} else {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(time);
				map.put(id, temp);
			}
		}

		ArrayList<Map.Entry<Integer, ArrayList<Integer>>> list = new ArrayList<Map.Entry<Integer, ArrayList<Integer>>>(
				map.entrySet());
		for (int i = 0; i < list.size(); ++i) {
			Entry<Integer, ArrayList<Integer>> entry = list.get(i);
			ArrayList<Integer> list2 = entry.getValue();
			int num = 0;
			int[] count = new int[t + 2];
			boolean flag = false;
			for (int j = 0; j < list2.size(); ++j)
				count[list2.get(j)]++;

			for (int j = 1; j <= t; ++j) {
				if (count[j] == 0) {
					if (num > 0)
						num--;
					if (num <= 3)
						flag = false;
				} else {
					num += count[j] * 2;
					if (num > 5)
						flag = true;
				}
			}
			if (flag)
				result++;
		}
		System.out.println(result);
	}

}
