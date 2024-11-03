package BOJ.binary_search;

import java.util.*;

public class BOJ_1939 {
    static ArrayList<Data>[] graph;
    static class Data implements Comparable<Data>{
        int where;
        int weight;
        public Data(int where, int weight){
            this.weight = weight;
            this.where = where;
        }

        @Override
        public int compareTo(Data o) {
            return this.weight - o.weight;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int max = 0;
        graph = new ArrayList[N + 1];

        for (int i = 0; i < N + 1; i++)
            graph[i] = new ArrayList<Data>();

        for (int i = 0; i < M; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int weight = sc.nextInt();
            graph[x].add(new Data(y,weight));
            graph[y].add(new Data(x,weight));

            max = Math.max(max, weight);
        }
        int start = sc.nextInt();
        int end = sc.nextInt();
        int left = 0;
        int right = max;
        int ans = -1;
        while (left <= right){
            int mid = (left + right) / 2;
            if(bfs(mid, start, end)){
                left = mid + 1;

                ans = Math.max(mid,ans);
            }else{
                right = mid - 1;
            }
        }
        System.out.println(ans);
    }

    private static boolean bfs(int mid, int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];
        visited[start] = true;
        q.add(start); // Data로 잡았을 때 q.add(graph[start].get(0)); 로 풀었던 적이 있는데 이것은 start에서 갈 수 있는 다음 그래프를 넣기 때문에 처음 스타트 지점을 거치지 않는다.
        while (!q.isEmpty()){
            int cur = q.poll();
            if(cur == end){
                return true;
            }
            int size = graph[cur].size();
            for (int i = 0; i < size; i++){
                Data next = graph[cur].get(i);
                if(!visited[next.where] && next.weight >= mid){
                    visited[next.where] = true;
                    q.add(next.where);
                }
            }
        }
        return false;
    }
}
