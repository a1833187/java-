package com.qrxedu.jsset;

/**
 * fa:集合号
 * @author qiu
 * @version 1.8.0
 */
public class JointSearchSet {
    int[] fa;
    public JointSearchSet(int n){
        fa = new int[n];
        //初始化集合号为其本身。
        for(int i = 0; i < n;i++){
            fa[i] = i+1;
        }
    }
    public int find(int x){
        //查找祖宗号并更新这条路线上的所有集合号
        if(x != fa[x]){
            fa[x] = find(fa[x]);
        }
        return fa[x];
    }
}
