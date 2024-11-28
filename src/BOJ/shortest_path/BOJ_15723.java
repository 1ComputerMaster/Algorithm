package BOJ.shortest_path;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_15723 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] map = new int[26][26];


        for (int[] m : map){
            Arrays.fill(m, 1000_000_000);
        }
        int N = sc.nextInt(); // 전제의 개수
        sc.nextLine(); // 버퍼 비우기
        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            char from = str.charAt(0);
            char to = str.charAt(str.length() - 1); // 마지막 문자
            int fromNum = from - 'a'; // 알파벳을 인덱스로 변환
            int toNum = to - 'a';
            map[fromNum][toNum] = 1; // 전제 관계 설정
        }

        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (map[i][k] + map[k][j] < map[i][j]) {
                        map[i][j] = 1; // i에서 k를 거쳐 j로 가는 경로가 가능
                    }
                }
            }
        }
        int M = sc.nextInt(); // 결론의 개수
        sc.nextLine(); // 버퍼 비우기
        for (int i = 0; i < M; i++) {
            String str = sc.nextLine();
            char from = str.charAt(0);
            char to = str.charAt(str.length() - 1);
            int fromNum = from - 'a';
            int toNum = to - 'a';

            if (map[fromNum][toNum] < 1000_000_000) {
                System.out.println("T");
            } else {
                System.out.println("F");
            }
        }
    }
}
