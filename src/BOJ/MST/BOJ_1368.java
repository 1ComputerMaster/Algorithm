package BOJ.MST;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * MST 활용 문제
 * 도시 분할 계획
 *
 * 두 동내의 간선중 제일 큰 간선 하나를 자른다. 이때의 MST 구조를 보면
 *
 * 다 연결된 거에서 (한 동내) 에서 가장 큰 간선 하나를 제거하는 구조로 두동내가 생기므로 이때가 최소의 합이 될 수 있다.
 *
 */


public class BOJ_1368 {
    private static final int INF = 987654321;

    static int N;
    static int ans;
    static class Data implements Comparable<Data>{
        int to;
        int weight; //연결비용
        public Data(int to, int weight){
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Data o) {
            return Integer.compare(this.weight,o.weight);
        }
    }
    static List<Data>[] graph;
    static boolean visited[];
    static int[] dept; //파는 비용

    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");

        N = Integer.parseInt(tk.nextToken());


        graph = new ArrayList[N + 1];
        dept = new int[N];

        for (int i = 0; i < N; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++){
            dept[i] = Integer.parseInt(in.readLine()); //파는 비용 계산
        }


        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(in.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int weight = Integer.parseInt(tk.nextToken());
                if (i != j) {
                    graph[i].add(new Data(j, weight));
                }
            }
        }

        int res = INF;
        for (int i = 0; i< N; i++) {
            ans = 0;
            prim(i);
            res = Math.min(res, ans);
        }
        System.out.println(res);
    }

    private static void prim(int start) {
        PriorityQueue<Data> q = new PriorityQueue<>();
        int[] distance = new int[N];
        boolean[] visited = new boolean[N];
        Arrays.fill(distance, INF);
        ans += dept[start];
        distance[start] = 0;

        q.add(new Data(start,0));
        while (!q.isEmpty()){
            Data now = q.poll();
            if(visited[now.to]){
                continue;
            }
            visited[now.to] = true;
            ans += distance[now.to];
            for (Data next : graph[now.to]){
                int nextWeight = Math.min(next.weight, distance[next.to]);
                if(!visited[next.to] && distance[next.to] > nextWeight){
                    q.offer(new Data(next.to,nextWeight));
                    distance[next.to] = nextWeight;
                }
            }
        }
    }
}