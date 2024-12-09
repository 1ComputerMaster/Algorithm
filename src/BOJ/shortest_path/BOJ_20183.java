package BOJ.shortest_path;

import java.io.*;
import java.util.*;

public class BOJ_20183 {
    static class Data implements Comparable<Data> {
        int node;
        long distance;
        long maxCost;

        public Data(int node, long distance, long maxCost) {
            this.node = node;
            this.distance = distance;
            this.maxCost = maxCost;
        }

        @Override
        public int compareTo(Data o) {
            // 최대 비용을 기준으로 정렬
            return Long.compare(this.maxCost, o.maxCost);
        }
    }

    static List<Data>[] graph;

    public static void main(String[] args) throws IOException {
        // BufferedReader로 입력 성능 개선
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 최대 비용 추적
        long maxCost = 0;
        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            long weight = Long.parseLong(st.nextToken());
            graph[from].add(new Data(to, weight, weight));
            graph[to].add(new Data(from, weight, weight));
            maxCost = Math.max(maxCost, weight);
        }

        // 이분 탐색 범위 조정
        long left = 0;
        long right = maxCost;
        long ans = -1;

        while (left <= right){
            long mid = (left + right) / 2;
            if(dijkstra(N, A, B, C, mid)){
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(ans);
    }

    private static boolean dijkstra(int n, int start, int end, long C, long maxAllowedCost) {
        PriorityQueue<Data> pq = new PriorityQueue<>();
        pq.add(new Data(start, 0, 0));

        boolean[] visited = new boolean[n + 1];

        while (!pq.isEmpty()){
            Data cur = pq.poll();

            if (cur.node == end) return true;

            if (visited[cur.node]) continue;
            visited[cur.node] = true;

            for (Data next : graph[cur.node]){
                // 경로의 최대 비용이 maxAllowedCost를 초과하지 않고
                // 총 이동 비용이 C를 초과하지 않는 경우
                long newMaxCost = Math.max(cur.maxCost, next.distance);
                if (newMaxCost <= maxAllowedCost &&
                        cur.distance + next.distance <= C &&
                        !visited[next.node]) {
                    pq.add(new Data(
                            next.node,
                            cur.distance + next.distance,
                            newMaxCost
                    ));
                }
            }
        }
        return false;
    }
}