package com.qrxedu;

/**
 * @author qiu
 * @version 1.8.0
 */
public class TestDemo {
    private static final String userName = "admin";
    public static void main(String[] args) {
        login("Admin");
    }
    public static void login(String name){
        if(!name.equals(userName)){
            throw new UserNameException("用户名错误！");
        }
    }
}
class UserNameException extends RuntimeException{
    public UserNameException(String message) {
        super(message);
    }
}
