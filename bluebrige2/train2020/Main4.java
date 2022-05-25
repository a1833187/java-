package train2020;

import java.util.Arrays;

public class Main4 {
	public static void main(String[] args) {
		String s = "tocyjkdzcieoiodfpbgcncsrjbhmugdnojjddhllnofawllbhfiadgdcdjstemphmnjihecoapdjjrprrqnhgccevdarufmliqijgihhfgdcmxvicfauachlifhafpdccfseflcdgjncadfclvfmadvrnaaahahndsikzssoywakgnfjjaihtniptwoulxbaeqkqhfwl";
		char[] c = s.toCharArray();
		int n = c.length;
		int[] count = new int[n];
		Arrays.fill(count, 1);
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < i; j++) {
				if(c[i] == c[j]) {
					count[i] = 0;
				}
				if(c[i] > c[j]) {
					count[i] += count[j];
				}
			}
		}
		long res = 0;
		for(int num : count) {
			res += num;
		}
		System.out.println(res);
	}
}
