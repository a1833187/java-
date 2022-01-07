package com.qrxedu.leedcode911;

/**
 * tml
 * @author qiu
 * @version 1.8.0
 */
public class TopVotedCandidate {
    public int[] persons;
    public int[] times;
    public int[] counts;
    public int max;
    public TopVotedCandidate(int[] persons, int[] times) {
        this.persons = persons;
        this.times = times;
        for(int i = 0;i<persons.length;i++){
            if(max < persons[i]){
                max = persons[i];
            }
        }
    }

    public int q(int t) {
        counts = new int[max+1];
        int i = 0;
        for(i = 0; i< times.length;i++){
            if(t>=times[i]){
                counts[persons[i]]++;
            }else{
                break;
            }
        }

        int index = 0;
        int max = counts[0];
        for(int j = 1; j < counts.length;j++){
            if(max < counts[j]){
                index = j;
                max = counts[j];
            }else if(max == counts[j]){
                for(int k = i - 1;k>=0;k--){
                    if(index == persons[k]){
                        break;
                    }else if(j == persons[k]){
                        index = j;
                        max = counts[j];
                        break;
                    }
                }
            }
        }
        return index;
    }
}
