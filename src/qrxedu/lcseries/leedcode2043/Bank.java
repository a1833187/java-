package qrxedu.lcseries.leedcode2043;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Bank {
    long[] balance;
    long len;
    public Bank(long[] balance) {
        this.balance = balance;
        len = balance.length;
    }

    public boolean transfer(int account1, int account2, long money) {
        if(account1 > len ||account1 < 1 || account2 > len || account2 < 1){
            return false;
        }
        if(balance[account1-1] < money){
            return false;
        }
        balance[account1-1] -= money;
        balance[account2-1] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if(account > len ||account < 1 ){
            return false;
        }
        balance[account-1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if(account > len ||account < 1 ){
            return false;
        }
        if(balance[account-1] < money){
            return false;
        }
        balance[account-1] -= money;
        return true;
    }
}
