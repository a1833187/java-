package qrxedu.e101;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E59 {
    public int[] map;
    public int cnt = 0;
    public int n;
    public int Nqueen (int _n) {
        // write code here
        n = _n;
        if(n == 1){
            return 1;
        }
        map = new int[n];
        for(int i = 0; i < n; i++){
            map[0] = i;
            dfs(1);
            map[0] = -1;
        }
        return cnt;
    }
    public void dfs(int index){
        if(index == n){
            cnt++;
            return;
        }

        for(int j = 0; j < n; j++){
            boolean flag = true;
            map[index] = j;
            for(int i = index-1; i >= 0; i--){
                if(!isV(index,i)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                dfs(index+1);
            }
            map[index] = -1;
        }
    }
    public boolean isV(int i,int j){
        return map[i] != map[j] && (Math.abs(map[i]-map[j]) != Math.abs(i-j));
    }
    @Test
    public void show(){
        System.out.println(Nqueen(8));
    }
}
