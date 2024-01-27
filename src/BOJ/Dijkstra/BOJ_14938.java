package BOJ.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author ksd5653
 *
 * Dijkstra로 도달 할 수 있는 최대 거리를 모두 가본다.
 * 
 * 1번째 입력
 * N = 지역 갯수
 * M = 수색 범위 (dist가 이것보다 작거나 같아야 한다.)
 * R = Edge의 갯수
 * 
 * 2번째 입력
 * N개의 숫자가 각 노드 (지역)의 아이템 갯수를 알려준다.
 *
 * 3번째 입력
 * 각 양 길의 a,b 노드 번호와 길의 길이를 알려준다.
 *
 *
 *
 */
public class BOJ_14938 {
    static class Data implements Comparable<Data>{
        int to; // 갈 곳
        int weight; //길의 길이

        public Data(int to, int weight){
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Data o) {
            return this.weight - o.weight;
        }
    }
    static int[] items; //items 갯수를 담는 배열
    static int N,M,R,ans;
    static List<Data> graph[];

    public static void main(String[] args) throws IOException{
        input();
        int max = 0;
        for (int i = 1; i <= N; i++){
            ans = 0;
            dijkstra(i);
            max = Math.max(max,ans);
        }
        System.out.println(max);
    }

    private static void dijkstra(int start) {
        boolean visited[] = new boolean[N + 1];
        Queue<Data> q = new PriorityQueue<>();
        q.add(new Data(start,0));
        int[] weight = new int[N + 1];

        while (!q.isEmpty()){
            Data now = q.poll();

            if(visited[now.to]){
                continue;
            }

            visited[now.to] = true;
            ans += items[now.to];
            for (Data next : graph[now.to]){
                if(!visited[next.to] && weight[now.to] + next.weight <= M){
                    weight[next.to] = weight[now.to] + next.weight;
                    q.add(next);
                }
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");

        N = Integer.parseInt(tk.nextToken());
        M = Integer.parseInt(tk.nextToken());
        R = Integer.parseInt(tk.nextToken());
        graph = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++){
            graph[i] = new ArrayList<Data>();
        }

        tk = new StringTokenizer(in.readLine()," ");

        items = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            items[i] = Integer.parseInt(tk.nextToken());
        }

        for (int i = 0; i < R; i++){
            tk = new StringTokenizer(in.readLine()," ");
            int from = Integer.parseInt(tk.nextToken());
            int to = Integer.parseInt(tk.nextToken());
            int weight = Integer.parseInt(tk.nextToken());
            graph[from].add(new Data(to,weight));
            graph[to].add(new Data(from,weight));
        }
    }
}
