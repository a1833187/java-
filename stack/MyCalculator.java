package com.qrxedu.stack;

/**
 * 用栈实现计算表达式
 *
 * @author qiu
 * @version 1.8.0
 */
public class MyCalculator {
    public static void main(String[] args) {
        ArrayStack numStack = new ArrayStack(10);
        ArrayStack operStack = new ArrayStack(10);
        int num1 = 0;
        int num2 = 0;
        String mNum = "";
        char ch = ' ';
        char yun = ' ';
        int res = 0;
        int index = 0;
        String expression ="20+700*2-1";
        while(true){
            ch = expression.charAt(index);
            if(operStack.isOper(ch)){
                if(!operStack.isEmpty()){
                    if(operStack.priority(ch)<= operStack.priority(operStack.peek())){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        res = operStack.operation(num1,num2,operStack.peek());
                        operStack.pop();
                        numStack.push(res);
                        operStack.push(ch);
                    }else{
                        //运算符优先级大，直接入栈
                        operStack.push(ch);
                    }
                }else{
                    //运算符栈为空,直接入栈
                    operStack.push(ch);
                }
            }else{
                //是数字
                int i = 1;
                mNum += ch;
                while(true){
                    if(index == expression.length()-1){
                        numStack.push(Integer.parseInt(mNum));
                        break;
                    }else{
                        if(!operStack.isOper(expression.charAt(index+i))){
                            mNum+=expression.charAt(index+i);
                            index++;
                        }else{
                            //下一位不是数字
                            numStack.push(Integer.parseInt(mNum));
                            mNum = "";
                            break;
                        }
                    }
                }

            }
            if(index == expression.length()-1){
                break;
            }
            index++;
        }
        while(!operStack.isEmpty()){
            num1 = numStack.pop();
            num2 = numStack.pop();
            res = operStack.operation(num1,num2,operStack.pop());
            numStack.push(res);
        }
        System.out.println("表达式的值为" + res);
    }
}

class ArrayStack {
    private int maxSize;
    private int top = -1;
    private int[] stack;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 入栈
     *
     * @param val
     */
    public void push(int val) {
        if (isFull()) {
            System.out.println("栈已满");
            return;
        }
        top++;
        stack[top] = val;
    }

    /**
     * 出栈
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        int val = stack[top];
        top--;
        return val;
    }

    /**
     * 返回栈顶元素
     */
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        return stack[top];
    }

    /**
     * 显示栈中元素(自上至下)
     */
    public void display() {
        if (isEmpty()) {
            System.out.println("栈为空");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    /**
     * 判断是否为运算符
     */
    public boolean isOper(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    /**
     * 判断运算符优先级
     */
    public int priority(int ch) {
        if (ch == '+' || ch == '-') {
            return 0;
        } else if (ch == '*' || ch == '/') {
            return 1;
        }
        return -1;
    }

    /**
     * 具体运算
     */
    public int operation(int num1,int num2,int ch){
        int res = 0;
        if(ch == '-'){
            res = num2 - num1;
        }
        if(ch == '+'){
            res = num2 + num1;
        }
        if(ch == '*'){
            res = num2 *num1;
        }
        if(ch == '/'){
            res = num2/num1;
        }
        return res;
    }
}