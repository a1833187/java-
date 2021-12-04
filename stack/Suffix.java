package com.qrxedu.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中缀表达式转后缀表达式
 * @author qiu
 * @version 1.8.0
 */
public class Suffix {
    public static void main(String[] args) {
        String s = "1+((2+3)*4)-5";
        System.out.println(transform(s));
        System.out.println(transform1(transform(s)));
    }

    /**
     * 中缀表达式转为后缀表达式
     */
     public static List<String> transform1(List<String> ls){
         Stack<String> s1 = new Stack<>();
         List<String> s2 = new ArrayList<>();
         for(String item:ls){
             //多位数直接加入到集合
             if(item.matches("\\d+")){
                 s2.add(item);
             }else if("(".equals(item)||s1.empty()){
                 //左括号直接入符号栈
                 s1.push(item);
             }else if(")".equals(item)){
                 //右括号则将栈中符号元素加入到集合中直到运算符栈顶元素为左括号
                 while(!"(".equals(s1.peek())){
                     s2.add(s1.pop());
                 }
                 //记得将左括号去掉
                 s1.pop();
             }else{
                 //运算符则与栈顶元素进行比较若为空或左括号则直接入栈
                 //若该运算符有优先级高于栈顶元素的优先级则直接入栈
                 //优先级低于则一直弹出栈顶元素直到不满足优先级低于的条件后再将运算符入栈
                 while(!s1.empty()&&operation(item)<=operation(s1.peek())){
                     s2.add(s1.pop());
                 }
                 s1.push(item);
             }
         }
         while(!s1.empty()){
             s2.add(s1.pop());
         }
         return s2;
    }

    public static int operation(String s){
         if("+".equals(s)||"-".equals(s)){
             return 1;
         }
         if("*".equals(s)||"/".equals(s)){
             return 2;
         }
        return 0;
    }
    /**
     * 将字符串形式的中缀表达式转换为集合存储
     * @param s
     * @return
     */
    public static List<String> transform(String s){
        List<String> ls = new ArrayList<>();
        int index = 0;
        char ch = ' ';
        String str = "";
        while(true){
            if((ch=s.charAt(index)) <48||(ch = s.charAt(index))>57){
                //非数字直接入集合
                ls.add(ch+"");
                index++;
            }else{
                //是数字要考虑多位数拼接问题
                while(index < s.length()&&(ch =s.charAt(index))>=48&&(ch = s.charAt(index))<=57){
                    str+=ch;
                    index++;
                }
                ls.add(str);
                str = "";
            }
            if(index == s.length()){
                break;
            }
        }
        return ls;
    }
}
