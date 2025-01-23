package BOJ.simulation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ_20436 {
    // 키보드 좌표를 저장하는 맵
    private static final Map<Character, int[]> keyboard = new HashMap<>();

    static {
        // 각 키의 좌표를 맵에 저장
        String[] keys = {
                "qwertyuiop",
                "asdfghjkl ",
                "zxcvbnm   "
        };
        for (int i = 0; i < keys.length; i++) {
            for (int j = 0; j < keys[i].length(); j++) {
                keyboard.put(keys[i].charAt(j), new int[]{i, j});
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 왼손 시작 위치
        char leftStart = sc.next().charAt(0);
        // 오른손 시작 위치
        char rightStart = sc.next().charAt(0);
        sc.nextLine(); // 버퍼 비우기
        // 입력할 문자열
        String input = sc.nextLine();

        // 초기 손가락 위치 설정
        int[] leftPos = keyboard.get(leftStart);
        int[] rightPos = keyboard.get(rightStart);

        int time = 0;

        for (char ch : input.toCharArray()) {
            int[] targetPos = keyboard.get(ch);
            if (isLeftHand(ch)) {
                // 왼손으로 입력하는 경우
                time += calculateDistance(leftPos, targetPos);
                leftPos = targetPos;
            } else {
                // 오른손으로 입력하는 경우
                time += calculateDistance(rightPos, targetPos);
                rightPos = targetPos;
            }
            time++; // 키 입력 시간 1초 추가
        }

        System.out.println(time);
    }

    // 해당 문자가 왼손으로 입력하는지 확인
    private static boolean isLeftHand(char ch) {
        return "qwertasdfgzxcv".indexOf(ch) != -1;
    }

    // 두 위치 간의 거리 계산
    private static int calculateDistance(int[] pos1, int[] pos2) {
        return Math.abs(pos1[0] - pos2[0]) + Math.abs(pos1[1] - pos2[1]);
    }
}