package qrxedu.lcseries.leedcode208;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Trie {
    static class TreeNode{
        boolean val;
        TreeNode[] children = new TreeNode[26];
    }
    private TreeNode root;
    public Trie() {
        root = new TreeNode();
    }

    public void insert(String word) {
        int n = word.length();
        TreeNode cur = root;
        for(int i = 0; i < n; i++){
            char ch = word.charAt(i);
            if(cur.children[ch-'a'] == null){
                cur.children[ch-'a'] = new TreeNode();
            }
            cur = cur.children[ch-'a'];
        }
        cur.val = true;
    }

    public boolean search(String word) {
        int n = word.length();
        TreeNode cur = root;
        for(int i = 0; i < n; i++){
            char ch = word.charAt(i);
            if(cur.children[ch-'a'] == null){
                return false;
            }
            cur = cur.children[ch-'a'];
        }
        return cur.val;
    }

    public boolean startsWith(String prefix) {
        int n = prefix.length();
        TreeNode cur = root;
        for(int i = 0; i < n; i++){
            char ch = prefix.charAt(i);
            if(cur.children[ch-'a'] == null){
                return false;
            }
            cur = cur.children[ch-'a'];
        }
        return true;
    }
}
