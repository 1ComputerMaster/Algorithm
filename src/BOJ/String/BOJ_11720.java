package BOJ.String;

import java.util.Scanner;

public class BOJ_11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String str = sc.next();
        int ans = 0;
        for (int i = 0; i < str.length(); i++)
            ans += Integer.parseInt(str.charAt(i) + "");
        System.out.println(ans);
    }
}
