package qrxedu.lcseries.leedcode553;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public String optimalDivision(int[] nums) {
        StringBuilder sb = new StringBuilder();
        if(nums.length == 1){
            return "" + nums[0];
        }
        if(nums.length == 2){
            return "" + nums[0] + "/" + "" + nums[1];
        }
        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                String cur = "" + nums[i];
                sb.append(cur);
                sb.append("/(");
            }else if(i != nums.length-1){
                String cur = "" + nums[i];
                sb.append(cur);
                sb.append("/");
            }else{
                String cur = "" + nums[i];
                sb.append(cur);
                sb.append(')');
            }
        }
        return sb.toString();
    }
}
