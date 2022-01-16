package com.qrxedu.lcseries.leedcode12;

/**
 * 我的解法
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public String intToRoman(int num) {
        int ge;
        int shi;
        int bai;
        int qian;
        String o = "";
        if(num>=1&&num<=9){
            ge = num%10;
            o += transform(ge,'I','V','X');
        }else if(num>=10&&num<=99){
            ge = num%10;
            shi = num/10;
            o+=transform(shi,'X','L','C');
            o+=transform(ge,'I','V','X');
        }else if(num>=100&&num<=999){
            ge = num%10;
            shi = num/10%10;
            bai = num/100;
            o+=transform(bai,'C','D','M');
            o+=transform(shi,'X','L','C');
            o+=transform(ge,'I','V','X');
        }else{
            ge = num%10;
            shi = num%100/10;
            bai = num/100%10;
            qian = num/1000;
            for(int i = 0;i<qian;i++){
                o+='M';
            }
            o+=transform(bai,'C','D','M');
            o+=transform(shi,'X','L','C');
            o+=transform(ge,'I','V','X');
        }
        return o;
    }
    public String transform(int position,char char1,char char2,char char3){
        int i;
        String o = "";
        if(position == 0){
            return o;
        }
        if(position>=1&&position<4){
            for(i = 0;i<3;i++){
                o+=char1;
            }
        }else if(position == 4){
            o+=char1;
            o+=char2;
        }else if(position<9){
            o+=char2;
            for(i = 0;i<position-5;i++){
                o+=char1;
            }
        }else{
            o+=char1;
            o+=char3;
        }
        return o;
    }

    /*
    题解:
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        StringBuffer roman = new StringBuffer();
        for (int i = 0; i < values.length; ++i) {
            int value = values[i];
            String symbol = symbols[i];
            while (num >= value) {
                num -= value;
                roman.append(symbol);
            }
            if (num == 0) {
                break;
            }
        }
        return roman.toString();
    }
     */
}
