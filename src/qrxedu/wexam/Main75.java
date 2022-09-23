package qrxedu.wexam;

import java.util.*;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main75 {
    static HashMap<Character,Integer> dict = new HashMap<>();
    static{
        dict.put('A',2);dict.put('B',2);dict.put('C',2);
        dict.put('D',3);dict.put('E',3);dict.put('F',3);
        dict.put('G',4);dict.put('H',4);dict.put('I',4);
        dict.put('J',5);dict.put('K',5);dict.put('L',5);
        dict.put('M',6);dict.put('N',6);dict.put('O',6);
        dict.put('P',7);dict.put('Q',7);dict.put('R',7);dict.put('S',7);
        dict.put('T',8);dict.put('U',8);dict.put('V',8);
        dict.put('W',9);dict.put('X',9);dict.put('Y',9);dict.put('Z',9);

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            List<String> list = new ArrayList<>();
            for(int i = 0; i < n; i++){
                String str = scanner.next();
                int m = str.length();
                StringBuilder s = new StringBuilder();
                for(int j = 0; j < m; j++){
                    char ch = str.charAt(j);
                    if(ch == '-'){
                        continue;
                    }
                    if(ch >='0' && ch <= '9'){
                        s.append(ch);
                    }else{
                        s.append(dict.get(ch));
                    }
                }
                s.insert(3,'-');
                list.add(new String(s));
            }
//            Collections.sort(list, new Comparator<String>() {
//                @Override
//                public int compare(String o1, String o2) {
//                    return o1.compareTo(o2);
//                }
//            });
            Set<String> set = new TreeSet<>(list);
            for(String str : set){
                System.out.println(str);
            }
            System.out.println();
        }
    }
}
