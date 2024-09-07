package BOJ.MST;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1197_RE {
    //최소 스패닝 트리 (MST 구현)
    /*
    * 모든 정점을 건너면서 이를 최소 비용으로 연결하여야 한다.
    *
    * 1 2 1
    * 2 3 2
    * 1 3 3
    * 의 경우 아래와 같이 움직이는 것이 가장 빠른 정점 찾기 로직이다.
    * 그러면, 한 정점에서 부터 시작해서 현재 위치로 부터 짧은 거리를 선택 하면 되지 않을까?
    *
    * 설계안 1)
    * 시작점(1) 부터 시작
    * for V
    * -> MST (int start)
    * -> PriorityQueue 구성
    * -> 가장 짧은 길이 값을 가져온다.
    * -> 이후에 모든 visited로 검출 된지 확인하는 로직을 거친다.
    *
    *  1 2 1000
    *  2 3 2
    *  3 4 50000
    *  2 4 10
    *  1 3 1
    * 1 - 3 - 2 - 4
    *
    * */

    static class Data implements Comparable<Data>{
        int next;
        long weight;
        public Data(int next, long weight){
            this.next = next;
            this.weight = weight;
        }

        @Override
        public int compareTo(Data o) {
            return Long.compare(this.weight, o.weight);
        }
    }
    static List<Data>[] listOfData;
    static Long ans = 1000_000_000L;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");

        int V = Integer.parseInt(tk.nextToken());
        int E = Integer.parseInt(tk.nextToken());
        listOfData = new ArrayList[V + 1];

        for (int i = 0; i < V + 1; i++){
            listOfData[i] = new ArrayList<Data>();
        }
        for (int i = 0; i < E; i++){
            tk = new StringTokenizer(in.readLine()," ");
            int A = Integer.parseInt(tk.nextToken());
            int B = Integer.parseInt(tk.nextToken());
            long C = Long.parseLong(tk.nextToken());
            listOfData[A].add(new Data(B,C));
            listOfData[B].add(new Data(A,C));

        }

        ans = Math.min(MST(V),ans);
        System.out.println(ans);
    }

    private static long MST(int size) {
        boolean[] visited = new boolean[size + 1];
        PriorityQueue<Data> pq = new PriorityQueue<>();
        List<Data> startData = listOfData[1];
        visited[1] = true;
        pq.addAll(startData);
        long dist = 0L;
        while (!pq.isEmpty()){
            Data cur = pq.poll();
            if(visited[cur.next]){
                continue;
            }
            visited[cur.next] = true;
            dist += cur.weight;
            List<Data> wayToGo = listOfData[cur.next];
            for (Data toGo : wayToGo) {
                if (!visited[toGo.next]) {
                    pq.add(toGo);
                }
            }
        }
        return check(visited) ? dist : 1000_000_000L;
    }

    private static boolean check(boolean[] visited) {
        for (int i = 1; i < visited.length; i++){
            if(!visited[i]){
               return false;
            }
        }
        return true;
    }
}
