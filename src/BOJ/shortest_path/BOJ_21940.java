package BOJ.shortest_path;

import java.util.*;

public class BOJ_21940 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        long[][] dist = new long[N + 1][N + 1];

        // 거리 배열 초기화
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE / 2);
            dist[i][i] = 0;
        }

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();
            dist[from][to] = Math.min(dist[from][to], weight);
        }

        // 플로이드-워셜 알고리즘
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        // 친구들의 위치 입력
        int K = sc.nextInt();
        int[] friends = new int[K];
        for (int i = 0; i < K; i++) {
            friends[i] = sc.nextInt();
        }

        // 최소 왕복 거리 계산
        long minMaxDistance = Long.MAX_VALUE;
        List<Integer> ansCities = new ArrayList<>();

        for (int city = 1; city <= N; city++) {
            long maxDistance = 0;

            for (int friend : friends) {
                //단뱡항 그래프
                if (dist[friend][city] == Long.MAX_VALUE/2 || dist[city][friend] == Long.MAX_VALUE /2) {
                    maxDistance = Long.MAX_VALUE;
                    break;
                }
                //왕복 시간이 다름
                maxDistance = Math.max(maxDistance, dist[friend][city] + dist[city][friend]);
            }

            // 최소 왕복 거리 비교 및 갱신
            if (maxDistance < minMaxDistance) {
                minMaxDistance = maxDistance;
                ansCities.clear();
                ansCities.add(city);
            } else if (maxDistance == minMaxDistance) {
                ansCities.add(city);
            }
        }
        Collections.sort(ansCities);
        for (int city : ansCities)
            System.out.print(city + " ");
    }
}
