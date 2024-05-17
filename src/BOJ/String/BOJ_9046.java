package BOJ.String;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class BOJ_9046 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 테스트 케이스의 수를 입력받음
        int T = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 소비

        for (int t = 0; t < T; t++) {
            String line = scanner.nextLine();
            HashMap<Character, Integer> frequencyMap = new HashMap<>();

            // 각 문자의 빈도를 계산
            for (char ch : line.toCharArray()) {
                if (ch != ' ') {
                    frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
                }
            }

            // 빈도가 가장 높은 문자 찾기
            char mostFrequentChar = '?';
            int highestFrequency = 0;
            boolean multipleMostFrequent = false;

            for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
                if (entry.getValue() > highestFrequency) {
                    mostFrequentChar = entry.getKey();
                    highestFrequency = entry.getValue();
                    multipleMostFrequent = false;
                } else if (entry.getValue() == highestFrequency) {
                    multipleMostFrequent = true;
                }
            }

            // 가장 빈번한 문자가 여러 개일 경우 '?'를 출력
            if (multipleMostFrequent) {
                System.out.println("?");
            } else {
                System.out.println(mostFrequentChar);
            }
        }
    }
}

