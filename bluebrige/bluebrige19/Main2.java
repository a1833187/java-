package bluebrige19;
import java.util.HashSet;

public class Main2 {
	static HashSet<String> set = new HashSet<>();
	public static void main(String[] args) {
		String str1 = "0100110001010001";
		String str = "aaab";
		StringBuffer s = new StringBuffer();
		dfs(s,0,str);
		System.out.print(set.size());
	}
	public static void dfs(StringBuffer s,int index,String str) {
		if(s.length() != 0 && !set.contains(s.toString())) {
			set.add(new String(s));
		}
		if(index == str.length()) {
			return;
		}
		for(int i = index; i < str.length(); i++){
			s.append(str.charAt(i));
			dfs(s,i+1,str);
			s.deleteCharAt(s.length()-1);
		}
	}
	
}
