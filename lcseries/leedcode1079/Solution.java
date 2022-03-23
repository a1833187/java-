package qrxedu.leedcode1079;

import java.util.HashSet;
import java.util.Set;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    Set<String> set;
    boolean[] isVisited;
    public int numTilePossibilities(String tiles) {
        set = new HashSet<>();
        isVisited = new boolean[tiles.length()];
        StringBuffer sb = new StringBuffer();
        dfs(tiles,sb);
        return set.size();
    }
    public void dfs(String tiles,StringBuffer sb){
        if(sb.length()!=0){
            set.add(new String(sb));
            if(sb.length() == tiles.length()){
                return;
            }
        }
        for(int i = 0; i < tiles.length(); i++){
            if(!isVisited[i]){
                isVisited[i] = true;
                sb.append(tiles.charAt(i));
                dfs(tiles,sb);
                sb.deleteCharAt(sb.length()-1);
                isVisited[i] = false;
            }
        }
    }
}
