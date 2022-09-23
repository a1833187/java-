package qrxedu.wexam;

import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main71 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            char[][] map = new char[20][20];
            for(int i = 0; i < 20; i++){
                String row = scanner.next();
                for(int j = 0; j < 20; j++){
                    map[i][j] = row.charAt(j);
                }
            }
            boolean flag = false;
            for(int i = 0; i < 20; i++){
                for(int j = 0; j < 20; j++){
                    if(map[i][j] == '.'){
                        continue;
                    }
                    if(isWin(i,j,map)){
                        flag = true;
                    }
                }
            }
            if(flag){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
    public static boolean isWin(int i,int j,char[][] map){
        char ch = map[i][j];
        if(j + 4 < 20){
            if(map[i][j+1] == ch && map[i][j+2] == ch && map[i][j+3] == ch && map[i][j+4] == ch){
                return true;
            }
        }
        if(i + 4 < 20){
            if(map[i+1][j] == ch && map[i+2][j] == ch && map[i+3][j] == ch && map[i+4][j] == ch){
                return true;
            }
        }
        if(i+4 < 20 && j + 4 < 20){
            if(map[i+1][j+1] == ch && map[i+2][j+2] == ch && map[i+3][j+3] == ch
            && map[i+4][j+4] == ch){
                return true;
            }
        }
        return false;
    }
}
