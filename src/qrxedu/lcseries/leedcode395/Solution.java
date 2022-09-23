package qrxedu.lcseries.leedcode395;

/**
 * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串，
 * 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
 *
 * @author qiu
 * @version 1.8.0
 * 分治求最长字串
 * 满足条件的最长字串一定不包含这样一个字符：该字符在母串中出现的次数为(0,k),因此以该字符为分隔符去
 * 分隔母串，则满足条件的最长字串一定是这些分隔串中的某一个
 * 如：ababdcdababab，以c为分隔符得到ababd和dababab，然后第一个以d为分隔符得到abab==》4，第二个以d为
 * 分隔符得到ababab==》6，因此答案为6
 */
public class Solution {
    public int longestSubstring(String s, int k) {
        return dfs(s, 0, s.length() - 1, k);
    }

    public int dfs(String s, int l, int r, int k) {
        int[] arr = new int[26];
        for (int i = l; i <= r; i++) {
            arr[s.charAt(i) - 'a']++;
        }
        char ch = ' ';
        for (int i = l; i <= r; i++) {
            if (arr[s.charAt(i) - 'a'] > 0 && arr[s.charAt(i) - 'a'] < k) {
                ch = s.charAt(i);
                break;
            }
        }
        if (ch < 'a' || ch > 'z') {
            return r - l + 1;
            //仅此一个递归出口
        }
        int i = l;
        int res = 0;
        while (i <= r) {
            //先找分隔符左边的子串，再找分隔符右边的子串
            //循环至多进行2次
            if (i <= r && s.charAt(i) == ch) {
                i++;
            }
            int start = i;
            while (i <= r && s.charAt(i) != ch) {
                i++;
            }
            //des接收的是满足条件的子串的长度,对应33行
            int des = dfs(s, start, i - 1, k);
            //Math.max()中的res为左，des为右
            res = Math.max(res, des);
        }
        return res;
    }
}
