package qrxedu.offer;

import java.util.*;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Offer38 {
    String[] ans;
    Set<String> set = new HashSet<>();
    int n;
    public String[] permutation(String s) {
        n = s.length();
        int len = 1;
        for(int i = 2; i <= n; i++){
            len *= i;
        }
        dfs(s,0);
        int k = 0;
        ans = new String[set.size()];
        for(String str : set){
            ans[k++] = str;
        }
        return ans;
    }
    public void dfs(String s,int index){
        if(index == n){
            String cur = new String(s);
            set.add(cur);
            return;
        }
        for(int i = index; i < n; i++){
            s = swap(s,i,index);
            dfs(s,index+1);
            s = swap(s,i,index);
        }
    }
    public String swap(String s,int i,int j){
        StringBuilder ss = new StringBuilder(s);
        char ch = ss.charAt(i);
        ss.setCharAt(i,ss.charAt(j));
        ss.setCharAt(j,ch);
        return new String(ss);
    }



    int N = 10;
    List<String> list = new ArrayList<>();
    boolean[] vis = new boolean[N];
    public String[] permutation1(String s) {
        char[] cs = s.toCharArray();
        Arrays.sort(cs);
        dfs(cs, 0, "");
        String[] ans = new String[list.size()];
        int idx = 0;
        for (String str : list) ans[idx++] = str;
        return ans;
    }
    void dfs(char[] cs, int u, String cur) {
        int n = cs.length;
        if (u == n) {
            list.add(cur);
            return;
        }
        for (int i = 0; i < n; i++) {
            //利用该判断进行去重,对于相同字符的cs[i]和cs[i-1],一般情况下有两种排列情况
            //1.cs[i-1]在前,cs[i]在后
            //2.cs[i]跳过cs[i-1]在前,cs[i-1]在后
            //这里的!vis[i-1]其实是跳过了第二种
            if (i > 0 && !vis[i - 1] && cs[i] == cs[i - 1]) {
                continue;
            }
            if (!vis[i]) {
                vis[i] = true;
                dfs(cs, u + 1, cur + cs[i]);
                vis[i] = false;
            }
        }
    }

}
