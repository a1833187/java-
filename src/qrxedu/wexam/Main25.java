package qrxedu.wexam;

import org.junit.jupiter.api.Test;


@SuppressWarnings("all")
/**
 * 取手套问题
 * 1.分别以左右手套为基准求出最少的手套个数.
 * 2.以左边手套为基准为例:
 * 当左边对应位置手套的个数为0直接跳过;
 * 当左边对应位置手套的个数不为0:
 * 1.右边对应位置手套个数为0,说明这种颜色的手套无法匹配成功,所以左边手套取的总个数要大于这种类型的手套的总个数.
 *2.右边对应位置手套个数不为0,说明可以匹配成功,这时为了达到最小,左边对应位置的手套的个数理应指取1个,
 * 右边为了达到必须匹配,需要在保证除了这个位置上的其他右边的手套的个数全部取一遍在加1个右边对应位置的手套.
 * 遍历左侧所有这种情况,取出对应的最大值(为了保证一定能够匹配)
 * 然后将情况1和情况2相加即可(意思是如果左边手套无法和右边手套匹配,那就要把这种手套的个数全部取完,如果能匹配,要选取右侧对应保证一定能够
 * 匹配成功的手套个数的最大值然后再+1(这是左边对应位置手套要取的个数))
 * 3.然后再以右边手套为基准,然后取两种情况的最小值.
 * @author qiu
 * @version 1.8.0
 */
public class Main25 {
    public int findMinimum(int n, int[] left, int[] right) {
        int l = getNum(n,left,right);
        int r = getNum(n,right,left);
        return Math.min(l,r);
    }
    public int getNum(int n,int[] left,int[] right){
        int maxL = 0,countL = 0;
        for(int i = 0; i < n; i++){
            if(left[i] != 0){
                if(right[i] == 0){
                    countL +=left[i];
                }else{
                    int sum = 1;
                    for(int j = 0; j < n; j++){
                        if(j != i){
                            sum+=right[j];
                        }
                    }
                    maxL = Math.max(maxL,sum+1);
                }
            }
        }
        return countL+maxL;
    }
    @Test
    public void show(){
        int[] left = {0,7,1,6};
        int[] right = {1,6,0,6};
        System.out.println(findMinimum(4,left,right));
    }
}
