package BOJ.shortest_path;

import java.util.*;

public class BOJ_21940 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        long[][] dist = new long[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE / 2);
            dist[i][i] = 0;
        }
        for (int i = 0; i < M; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            long weight = sc.nextLong();
            dist[from][to] = weight;
        }
        int K = sc.nextInt();
        List<Integer> friends = new ArrayList<>();
        for (int k = 0; k < K; k++){
            friends.add(sc.nextInt());
        }
        // 플로이드-워셜 알고리즘
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        long minDist = Long.MAX_VALUE / 2;
        List<Integer> ansList = new ArrayList<>();
        for (int go = 1; go <= N; go++) {
            long maxDistance = 0;
            for (int friend : friends) {
                if (dist[friend][go] != Long.MAX_VALUE / 2 && dist[go][friend] != Long.MAX_VALUE / 2) {
                    maxDistance = Math.max(maxDistance, dist[friend][go] + dist[go][friend]);
                }
            }
            if(minDist > maxDistance){
                minDist = maxDistance;
                ansList.clear();
                ansList.add(go);
            }
            else if(minDist == maxDistance){
                ansList.add(go);
            }
        }
        for (int ans : ansList){
            System.out.print(ans + " ");
        }
    }
}
