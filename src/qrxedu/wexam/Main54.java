package qrxedu.wexam;

import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main54 {
    public static int[] month = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    public static int[] money = {0,2,1,1,2,1,2,1,2,2,2,1,2};
    public static int y = 0;
    static {
        for(int i = 1; i <= 12; i++){
            y+=month[i]*money[i];
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.nextLine();
            String[] strs = str.split(" ");
            int yearS = Integer.parseInt(strs[0]);
            int yearE = Integer.parseInt(strs[3]);
            int monthS = Integer.parseInt(strs[1]);
            int dayS = Integer.parseInt(strs[2]);
            int monthE = Integer.parseInt(strs[4]);
            int dayE = Integer.parseInt(strs[5]);
            boolean flag1 = isRun(yearS);
            boolean flag2 = isRun(yearE);

            int moneyS = 0;
            if(flag1 && monthS == 2){
                moneyS = (month[monthS]+1-dayS+1)*money[monthS];
            }else{
                moneyS = (month[monthS]-dayS+1)*money[monthS];
            }
            int moneyE = dayE*money[monthE];
            //同一年
            if(yearS == yearE){
                //同一月份
                if(monthS == monthE){
                    System.out.println((dayE-dayS+1)*money[monthS]);
                }else{
                    int sum = moneyS+moneyE;
                    for(int i = monthS+1; i < monthE;i++){
                        if(flag1 && i == 2){
                            sum += (month[i]+1)*money[i];
                        }else{
                            sum += month[i]*money[i];
                        }
                    }
                    System.out.println(sum);
                }
            }else{
                //先算首年和尾年,然后算中间的.
                //首年的利润.
                int ymS = moneyS;
                for(int i = monthS+1; i <= 12;i++){
                    if(flag1 && i == 2){
                        ymS += (month[i]+1)*money[i];
                    }else{
                        ymS += month[i] * money[i];
                    }
                }
                //尾年的利润
                int ymE = moneyE;
                for(int i = 1; i < monthE;i++){
                    if(flag2 && i == 2){
                        ymE += (month[i]+1)*money[i];
                    }else{
                        ymE += month[i] * money[i];
                    }
                }
                //算中间年的利润
                int sum = ymS + ymE;
                for(int i = yearS+1; i < yearE;i++){
                    boolean flag = isRun(i);
                    if(flag){
                        sum = sum +y +1;
                    }else{
                        sum = sum + y;
                    }
                }
                System.out.println(sum);
            }
        }
    }
    public static boolean isRun(int year){
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }
}
