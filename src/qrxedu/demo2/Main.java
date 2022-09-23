package qrxedu.demo2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        while(scanner.hasNextLine()){
            String n = scanner.nextLine();
            list.add(n);
        }
        for(int i = 0; i < list.size(); i++){
            String str = list.get(i);
            int k = 0;
            for(int j = 0; j < str.length(); j++){
                if(j > 0 && str.charAt(j) == ' ' && str.charAt(j-1) != ' '){
                    set.add(str.substring(k,j));
                    k = j + 1;
                }
                if(j == str.length() - 1){
                    set.add(str.substring(k,j+1));
                }
            }
        }
        System.out.println(set.size());
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int cnt = 1;
        int cur = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            if(cur <= intervals[i][0]){
                cnt++;
                cur = intervals[i][1];
            }
        }
        return cnt;
    }
}
