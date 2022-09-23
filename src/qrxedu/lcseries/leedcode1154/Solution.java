package qrxedu.lcseries.leedcode1154;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int dayOfYear(String date) {
        int year = Integer.parseInt(date.substring(0,4));
        boolean flag = false;
        if(year % 4 == 0 && year % 100 != 0 ||year % 400 == 0){
            flag = true;
        }
        int month = Integer.parseInt(date.substring(5,7));
        int day = Integer.parseInt(date.substring(8,10));
        int res = 0;
        if(month == 1){
         res += day;
         return res;
        }
        if(month == 2){
            res += 31 + day;
            return res;
        }
        int sum = 0;
        if(flag){
            sum = 60;
        }else{
            sum = 59;
        }
        switch (month){
            case 3:{
                res = sum + day;
                break;
            }
            case 4:{
                res = sum + 31 + day;
                break;
            }
            case 5:{
                res = sum + 61 + day;
                break;
            }
            case 6:{
                res = sum + 92 + day;
                break;
            }
            case 7:{
                res = sum + 122 + day;
                break;
            }
            case 8:{
                res = sum + 153 + day;
                break;
            }
            case 9:{
                res = sum + 184 + day;
                break;
            }
            case 10:{
                res = sum + 214 + day;
                break;
            }
            case 11:{
                res = sum + 245 + day;
                break;
            }
            case 12:{
                res = sum + 275 + day;
                break;
            }
            default:res = 0;
        }
        return res;
    }
}
