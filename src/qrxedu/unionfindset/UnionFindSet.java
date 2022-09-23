package qrxedu.unionfindset;

import java.util.Arrays;

/**
 * @author qiu
 * @version 1.8.0
 */
public class UnionFindSet {
    //存储每个元素的父亲下标,如果为负数说明该元素为某个集合的根,绝对值大小为集合的个数
    public int[] elem;

    public UnionFindSet(int len){
        this.elem = new int[len];
        Arrays.fill(elem,-1);
    }
    public void union(int a,int b){
        a = find(a);
        b = find(b);
        if(a == b){
            return;
        }
        elem[a] = elem[a] + elem[b];
        elem[b] = a;
    }

    /**
     * 查询a和b是否在同一个集合
     * @param a
     * @param b
     * @return
     */
    public boolean isSameUnion(int a,int b){
        return find(a) == find(b);
    }
    public int find(int a){
      if(a < 0){
        throw new IndexOutOfBoundsException("下标为负数,为非法值");
      }
      while(elem[a] >= 0){
          a = elem[a];
      }
      return a;

    }

    public int getCount(){
        int count = 0;
        for(int x : elem){
            if(x < 0){
                count++;
            }
        }
        return count;
    }

    /**
     * 打印每个元素的父亲节点(根节点的含义)
     */
    public void print(){
        for(int x : elem){
            System.out.println(x);
        }
        System.out.println();
    }
}
