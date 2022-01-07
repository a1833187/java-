package com.qrxedu.leedcode911;

/**
 * @author qiu
 * @version 1.8.0
 */
public class TestDemo {
    public static void main(String[] args) {
        int[] a = {0,1,1,0,2,2,0,2,3,1};
        int[] time = {2,4,11,17,20,43,53,81,91,97};

        TopVotedCandidate topVotedCandidate = new TopVotedCandidate(a,time);
        System.out.println(topVotedCandidate.q(91));
    }
}
