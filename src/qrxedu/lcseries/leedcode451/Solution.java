package qrxedu.lcseries.leedcode451;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public String frequencySort(String s) {
       int[][] count = new int[75][2];
       for(int i = 0; i < s.length();i++){
           count[s.charAt(i) - '0'][1]++;
           count[s.charAt(i) - '0'][0] = s.charAt(i);
       }
       int len = count.length;
       for(int i = 0; i < len - 1;i++){
           for(int j = 0; j < len - 1 - i; j++){
               if(count[j][1] < count[j+1][1]){
                   swap(count,j,j+1,1);
                   swap(count,j,j+1,0);
               }
           }
       }
       StringBuilder sb = new StringBuilder();
       for(int i = 0;i < len;i++){
           if(count[i][1] != 0){
               for(int j = 0; j < count[i][1];j++){
                   sb.append((char)(count[i][0]));
               }
           }
       }
       return sb.toString();
    }
    public void swap(int[][] array,int a,int b,int w){
        int tmp = array[a][w];
        array[a][w] = array[b][w];
        array[b][w] = tmp;

    }
    @Test
    public void show(){
        System.out.println(frequencySort("Aabb"));
    }
}
