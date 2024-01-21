package BOJ.MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_14621 {
    private static class Data implements Comparable<Data>{
        int end;
        boolean sex;
        int weight;
        public Data(int end, boolean sex, int weight) {
            this.end = end;
            this.sex = sex;
            this.weight = weight;
        }
        @Override
        public int compareTo(Data o) {
            return this.weight - o.weight;
        }
    }
    private static List<Data>[] list;
    private static char[] sex;
    private static boolean visited[];
    private static int N,M,cnt;

    private static int ans;
    public static void main(String[] args) throws Exception{
        ans = 0;
        input();
        Prim();
        if(cnt != N) {
            System.out.println(-1);
        }else{
            System.out.println(ans);
        }
    }

    private static void Prim() {
        PriorityQueue<Data> pq = new PriorityQueue<Data>();
        pq.offer(new Data(1, sex[0] == 'M',0));
        while(!pq.isEmpty()){
            Data now = pq.poll();
            if(visited[now.end]){
                continue;
            }
            cnt++;
            visited[now.end] = true;
            ans += now.weight;
            for (Data next : list[now.end]){
                if(!visited[next.end] && next.sex != now.sex){
                    pq.offer(next);
                }
            }
        }
    }
    private static void input() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");
        N = Integer.parseInt(tk.nextToken()); //정점의 갯수
        M = Integer.parseInt(tk.nextToken()); //간선의 갯수
        list = new ArrayList[N + 1];

        sex = new char[N];
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++){
            list[i] = new ArrayList<Data>();
        }

        tk = new StringTokenizer(in.readLine()," ");
        for (int i = 0; i < N; i++){
            sex[i] = tk.nextToken().charAt(0);
        }

        for (int i = 0; i < M; i++){
            tk = new StringTokenizer(in.readLine(), " ");
            int u = Integer.parseInt(tk.nextToken());
            int v = Integer.parseInt(tk.nextToken());
            int d = Integer.parseInt(tk.nextToken());
            list[u].add(new Data(v, sex[v - 1] == 'M',d));
            list[v].add(new Data(u, sex[u - 1] == 'M',d));
        }
    }
}
