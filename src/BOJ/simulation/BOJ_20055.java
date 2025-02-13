package BOJ.simulation;

import java.util.Scanner;

public class BOJ_20055 {
    static int N,K; // 컨베이어 벨트 상단 칸의 개수
    static int[] belt; // 전체 벨트 내구도 배열 (길이 2*N)
    static boolean[] robot; // 상단 벨트에 로봇 존재 여부 배열
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        belt = new int[N * 2];

        robot = new boolean[N];

        for (int i = 0; i < N * 2; i++){
            belt[i] = sc.nextInt();
        }

        int cnt = 0;
        while (!beltDurabilityCheck()){
            cnt++;
            rotateBelt();
            robotMove();
            beltBreaker();
        }
        System.out.println(cnt);
    }
    static boolean beltDurabilityCheck(){
        int cnt = 0;
        for (int i = 0; i < N * 2; i++){
            if(belt[i] == 0){
                cnt++;
            }
        }
        return cnt >= K;
    }

    static void beltBreaker(){
        if(belt[0] > 0 && !robot[0]){
            robot[0] = true;
            belt[0] -= 1;
        }
    }

    static void robotMove(){
        for (int i = N - 1; i >= 1; i--) {
            if(belt[i] > 0 && robot[i - 1] && !robot[i]){
                belt[i]--;
                robot[i - 1] = false;
                robot[i] = true;
            }
        }
        if(robot[N - 1]){
            robot[N - 1] = false;
        }

    }
    static void rotateBelt() {
        // 1. 벨트 배열 회전: 마지막 칸을 첫 칸으로 이동
        int last = belt[2 * N - 1];
        for (int i = 2 * N - 1; i >= 1; i--) {
            belt[i] = belt[i - 1];
        }
        belt[0] = last;

        // 2. 로봇 배열 회전: 상단 벨트(길이 N)만 회전
        // 오른쪽(즉, 인덱스가 증가하는 방향)으로 한 칸씩 이동
        for (int i = N - 1; i >= 1; i--) {
            robot[i] = robot[i - 1];
        }
        robot[0] = false;

        // 3. 내리는 위치(상단 벨트의 N번째 칸, 즉 인덱스 N-1)에 로봇이 있으면 내린다.
        if (robot[N - 1]) {
            robot[N - 1] = false;
        }
    }
}
