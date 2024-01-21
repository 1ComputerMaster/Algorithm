package BOJ.greedy;

import java.util.Scanner;

public class BOJ_23797 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        int frogCount = 1;

        for (int i = 1; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            char prevChar = s.charAt(i - 1);

            if (currentChar == prevChar) {
                // 현재 문자와 이전 문자가 같으면 새로운 개구리의 시작
                frogCount++;
            }
        }

        System.out.println(frogCount);
    }
}
