package Programmers.simulation;

public class PRO_KAKAO_WINTER_도넛과_막대_그래프 {
    public static void main(String[] args) {
        PRO_KAKAO_WINTER_도넛과_막대_그래프 sol = new PRO_KAKAO_WINTER_도넛과_막대_그래프();
        int[] answers = sol.solution(new int[][]{{2, 3}, {4, 3}, {1, 1}, {2, 1}}); // Example input
        for (int ans : answers) {
            System.out.print(ans + " "); // Expected output: [2, 1, 1, 0]
        }
    }
    static int N;
    public int[] solution(int[][] edges) {
        for(int[] e : edges){
            int u = e[0], v = e[1];
            N = Math.max(N, Math.max(u, v));
        }

        N += 1;

        int[] ingoing = new int[N];
        int[] outgoing = new int[N];

        for(int[] edge : edges) {
            outgoing[edge[0]]++;
            ingoing[edge[1]]++;
        }

        int created = 0;
        int eight = 0;
        int stick = 0;

        for (int i = 1; i < N; i++){
            if(outgoing[i] >= 2){
                if(ingoing[i] == 0){
                    created = i;
                } else if (ingoing[i] >= 2) {
                    eight++;
                }
            }
            if(ingoing[i] > 0 && outgoing[i] == 0){
                stick++;
            }
        }
        return new int[]{created, outgoing[created] - stick - eight, stick, eight};
    }

}
