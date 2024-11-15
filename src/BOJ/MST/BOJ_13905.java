package BOJ.MST;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_13905 {
    /**
     * 문제 
     * - 혜빈이 한태 숭이는 최대로 가져 갈 수 있는 빼빼로 갯수를 구해야 함
     * 
     * 원인
     * - 각 거리마다 무게 제한이 있고 무게 제한 이상으로 빼빼로를 들고 갈 수는 없음
     *  -> 따라서, BFS로 모두 탐색을 하자. 그런데 Binary Search를 곁들인
     */
    static class Data {
        int next;
        long weight;
        public Data(int next, long weight){
            this.next = next;
            this.weight = weight;
        }
    }
    static List<Data>[] listOfData;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine(), " ");

        int V = Integer.parseInt(tk.nextToken());
        int E = Integer.parseInt(tk.nextToken());
        listOfData = new ArrayList[V + 1];

        for (int i = 0; i < V + 1; i++) {
            listOfData[i] = new ArrayList<Data>();
        }

        tk = new StringTokenizer(in.readLine(), " ");

        int s = Integer.parseInt(tk.nextToken());
        int e = Integer.parseInt(tk.nextToken());
        long right = 0;
        for (int i = 0; i < E; i++) {
            tk = new StringTokenizer(in.readLine(), " ");
            int A = Integer.parseInt(tk.nextToken());
            int B = Integer.parseInt(tk.nextToken());
            long C = Long.parseLong(tk.nextToken());
            listOfData[A].add(new Data(B, C));
            listOfData[B].add(new Data(A, C));
            right = Math.max(right,C);
        }
        binarySearch(s,e,V + 1,right);

    }

    private static void binarySearch(int start, int end, int n, long firstRight) {
        long left = 0;
        long right = firstRight;
        long ans = 0;
        while (left <= right){
            long mid = (left + right) / 2;
            if(canIGo(start,end,mid,n)){
                left = mid + 1;
                ans = mid;
            } else{
                right = mid - 1;
            }
        }
        System.out.println(ans);
    }

    private static boolean canIGo(int start, int end, long mid, int n) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        visited[start] = true;
        q.add(start);
        while (!q.isEmpty())
        {
            int x = q.poll();
            for (Data next : listOfData[x]){
                if(next.weight >= mid && !visited[next.next]){
                    q.add(next.next);
                    visited[next.next] = true;
                }
            }
        }
        return visited[end];
    }
}
