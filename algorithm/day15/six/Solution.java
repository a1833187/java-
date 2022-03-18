package qrxedu.algorithm.day15.six;

import java.util.Arrays;

/**
 * 任务调度，把m个任务分配给n个机器，每个机器上只能同时执行1个任务，任务不可被分割。
 * 求任务完成的最短时间。
 * 贪心：每次都将任务时长最长的任务优先放到机器上。
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int minTime(int[] taskTime, int m){
        int n = taskTime.length;
        int[] machines = new int[n];
        Arrays.sort(taskTime);
        if(m <= n){
            return taskTime[n-1];
        }else{
            for(int i = 0; i < n; i++){
                int finish = 0;
                for(int j = 1; j < m; j++){
                    if(machines[finish] > machines[j]){
                        finish = j;
                    }
                }
                machines[finish] += taskTime[i];
            }
        }
        return maxOfMachine(machines);
    }
    public int maxOfMachine(int[] machines){
        int max = machines[0];
        for(int i = 1; i < machines.length; i++){
            max = Math.max(max,machines[i]);
        }
        return max;
    }
}
