package qrxedu.sort;

import java.util.*;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main2 {
    static List<String> list;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        list = new ArrayList<>();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = i+1;
        }
        dfs(arr,0);
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        for(String str : list){
            System.out.println(str);
        }
    }
    public static void dfs(int[] arr,int index){
        if(index == arr.length){
            StringBuffer sb = new StringBuffer();
           for(int i = 0; i < arr.length;i++){
               sb.append(arr[i]);
               sb.append(' ');
           }
           list.add(sb.toString());
        }
        for(int i = index; i < arr.length; i++){
            swap(arr,i,index);
            dfs(arr,index+1);
            swap(arr,i,index);
        }

    }
    public static void swap(int[] arr,int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
