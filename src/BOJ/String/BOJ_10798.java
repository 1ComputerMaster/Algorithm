package BOJ.String;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_10798 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> stringList = new ArrayList<>();

        int maxLen = 0;
        for (int i = 0; i < 5; i++) {
            String str = sc.next();
            maxLen = Math.max(maxLen, str.length());
            stringList.add(str);
        }
        for (int j = 0; j <= maxLen; j++) {
            for (int i = 0; i < stringList.size(); i++) {
                char[] ctr = stringList.get(i).toCharArray();
                if(ctr.length <= j){
                    continue;
                }
                System.out.print(ctr[j]);
            }
        }
    }
}
