package BOJ.shortest_path;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_11265_RE {
    static int[][] map;
    static class Node implements Comparable<Node> {
        int index, distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine(), " ");
        int N = Integer.parseInt(tk.nextToken());
        int M = Integer.parseInt(tk.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++){
            tk = new StringTokenizer(in.readLine(), " ");
            for (int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(tk.nextToken());
            }
        }
        for (int i = 0; i < M; i++){
            tk = new StringTokenizer(in.readLine(), " ");
            int from = Integer.parseInt(tk.nextToken()) - 1;
            int to = Integer.parseInt(tk.nextToken()) - 1;
            int weight = Integer.parseInt(tk.nextToken());
            if (dijkstra(from, to, weight, N)) {
                System.out.println("Enjoy other party");
            } else {
                System.out.println("Stay here");
            }
        }
    }
    private static boolean dijkstra(int start, int end, int weight, int size) {
        int[] dist = new int[size];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int curNode = curr.index;
            int curDist = curr.distance;

            if (curDist > dist[curNode]) {
                continue;
            }

            for (int i = 0; i < size; i++) {
                if (curDist + map[curNode][i] < dist[i]) {
                    dist[i] = curDist + map[curNode][i];
                    pq.add(new Node(i, dist[i]));
                }
            }
        }

        return dist[end] <= weight;
    }
}
