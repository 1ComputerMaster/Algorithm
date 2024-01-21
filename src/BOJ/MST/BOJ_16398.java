package BOJ.MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class BOJ_16398 {
    static class Data implements Comparable<Data> {
        int end;
        int weight;

        public Data(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Data o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Data>[] list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int cost = Integer.parseInt(st.nextToken());
                list[i].add(new Data(j, cost));
            }
        }

        long result = findMinimumFlowCost(N, list);
        System.out.println(result);
    }

    private static long findMinimumFlowCost(int V, ArrayList<Data>[] list) {
        boolean[] visited = new boolean[V + 1];
        PriorityQueue<Data> pq = new PriorityQueue<>();

        pq.offer(new Data(1, 0));
        long max = 0;

        while (!pq.isEmpty()) {
            Data cur = pq.poll();

            if (visited[cur.end]) {
                continue;
            }

            visited[cur.end] = true;
            max += cur.weight;
            for (Data next : list[cur.end]) {
                if (!visited[next.end]) {
                    pq.offer(new Data(next.end, next.weight));
                }
            }
        }

        return max;
    }
}