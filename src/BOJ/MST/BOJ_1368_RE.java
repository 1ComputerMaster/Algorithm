package BOJ.MST;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1368_RE {
    static class Data implements Comparable<Data>{
        int where;
        int weight;
        public Data(int where, int weight){
            this.weight = weight;
            this.where = where;
        }
        @Override
        public int compareTo(Data o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] W = new int[N];
        for (int i = 0; i < N; i++){
            W[i] = sc.nextInt();
        }

        int[][] to = new int[N][N];

        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                to[i][j] = sc.nextInt();
            }
        }
        System.out.printf("%d", MST(W, to, N));
    }

    private static int MST(int[] W, int[][] to, int n) {
        PriorityQueue<Data> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n];
        int res = 0;

        // 각 논과 가상의 우물(가상의 노드) 간의 엣지를 추가합니다.
        for (int i = 0; i < n; i++) {
            pq.add(new Data(i, W[i]));  // 우물을 파는 비용을 엣지로 추가
        }

        while (!pq.isEmpty()) {
            Data cur = pq.poll();
            if (visited[cur.where]) {
                continue;
            }
            visited[cur.where] = true;
            res += cur.weight;

            // 현재 논에서 다른 논으로의 물길을 탐색
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    pq.add(new Data(i, to[cur.where][i]));
                }
            }
        }
        return res;
    }

}
