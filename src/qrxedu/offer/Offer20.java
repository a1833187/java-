package qrxedu.offer;

import org.junit.jupiter.api.Test;

/**
 * 字符串模拟
 * @author qiu
 * @version 1.8.0
 */
@SuppressWarnings("all")
public class Offer20 {
    public boolean isNumber(String s) {
        int n = s.length();
        int st = 0;
        int en = n-1;
        //去掉首尾的空格
        while(st < n){
            if(s.charAt(st) == ' '){
                st++;
            }else{
                break;
            }
        }
        while(en >= 0){
            if(s.charAt(en) == ' '){
                en--;
            }else{
                break;
            }
        }
        if(st > en){
            return false;
        }
        s = s.substring(st,en+1);
        n = s.length();
        //中间有空格或非法字母则直接返回false
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == ' '){
                return false;
            }
            if((s.charAt(i) >= 'a' && s.charAt(i) <= 'z' && s.charAt(i) != 'e')
            || s.charAt(i) >= 'A' && s.charAt(i) <= 'Z' && s.charAt(i) != 'E'){
                return false;
            }
        }
        int cnt = 0;
        int index = 0;
        //判断是否有e(E)
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == 'e' || s.charAt(i) == 'E'){
                index = i;
                cnt++;
            }
            if(cnt > 1){
                return false;
            }
        }
        if(cnt == 1){
            //有e(E)
            String s1 = s.substring(0,index);
            String s2 = s.substring(index+1,n);
            if(s2.length() == 0){
                return false;
            }
            //e前面是小数或整数,e后面是整数
            if(isXi(s1) || isZh(s1)){
                return isZh(s2);
            }else{
                return false;
            }
        }else{
            //没有e(E),判断是否是一个小数或整数
            if(isZh(s) || isXi(s)){
                return true;
            }else{
                return false;
            }
        }

    }
    //去掉整数和小数前的符号
    public String removeFu(String s){
        if(s.length() == 0){
            return s;
        }
        if(s.charAt(0) == '+' || s.charAt(0) == '-'){
            return s.substring(1);
        }
        return s;
    }
    //判断是否是一个整数
    public boolean isZh(String s){
        s = removeFu(s);
        int n = s.length();
        if(n == 0){
            return false;
        }
        for(int i = 0; i < n; i++){
            if(!(s.charAt(i) >= '0' && s.charAt(i) <= '9')){
                return false;
            }
        }
        return true;
    }
    //判断是否是一个小数
    public boolean isXi(String s){
        s = removeFu(s);
        int n = s.length();
        if(n == 0){
            return false;
        }
        int cnt = 0;
        int index = 0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '.'){
                cnt++;
                index = i;
            }
            if(cnt > 1){
                return false;
            }
        }
        if(cnt == 1) {
            String s1 = s.substring(0, index);
            String s2 = s.substring(index + 1, n);
            if (isZh(s1) || isZh(s2)) {
                //小数点后面的整数不能带符号
                return !(s2.contains("+") || s2.contains("-"));
            }else{
                return false;
            }
        }
        return false;
    }
    @Test
    public void show(){
        String s = "G76";
        System.out.println(isNumber(s));
    }
}
