package BOJ.String;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ_20154 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        Map<Character, Integer> map = new HashMap<>();
        char[] alphabets = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        int[] numbers = {3, 2, 1, 2, 3, 3, 3, 3, 1, 1, 3, 1, 3, 3, 1, 2, 2, 2, 1, 2, 1, 1, 2, 2, 2, 1};

        for (int i = 0; i < alphabets.length; i++) {
            map.put(alphabets[i], numbers[i]);
        }
        int ans = 0;
        for (int i = 0; i < str.length(); i++){
            ans += map.get(str.charAt(i));
        }

        if(ans % 2 == 0){
            System.out.println("You're the winner?");
        }else {
            System.out.println("I'm a winner!");
        }
    }
}
