package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class NetworkDelayTime {
    static class Data implements Comparable<Data>{
        int where;
        int priority;
        public Data(int where, int priority){
            this.where = where;
            this.priority = priority;
        }

        @Override
        public int compareTo(Data o) {
            return Integer.compare(this.priority, o.priority);
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List[] graph = new List[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<Data>();
        }

        Queue<Data> pq = new PriorityQueue<>();
        for(int[] t : times){
            int from = t[0];
            int to = t[1];
            int weight = t[2];
            graph[from].add(new Data(to, weight));
        }
        int[] dist = new int[n + 1];
        for(int i = 1; i <= n; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[k] = 0;
        pq.offer(new Data(k, 0));
        while(!pq.isEmpty()){
            Data cur = pq.poll();
            for (Object obj : graph[cur.where]) {
                Data next = (Data) obj;
                // Queue 내에서 가장 우선 순위가 높은 데이터를 꺼냈을 때, 이미 더 짧은 경로를 알고 있다면 무시
                // 왜냐하면 지금 테스트 케이스 기준 2번 노드에서 1번 노드로 가는 경로가 1인데, 2->3->1로 가는 경로가 2이기 때문에
                // 우선순위 큐에 남아있는 2->3 , 2->1 경로를 한번에 처리할 때, 한번에 처리를 해야한다.
                // 따라서, 최소 거리를 가지는 값으로 판별해야 하며 하나씩 PQ에서 꺼낼 때 마다 한 노드 위치에서 다른 노드 위치로 가는 것을
                // dist += weight 형식으로 처리하면 안된다.
                // 즉, dist 배열은 각 노드까지의 최단 거리를 저장하고 있어야 한다.
                if(dist[next.where] > dist[cur.where] + next.priority){
                    dist[next.where] = dist[cur.where] + next.priority;
                    pq.offer(new Data(next.where, dist[next.where]));
                }
            }
        }
        int answer = 0;
        for(int i = 1; i <= n; i++){
            if(dist[i] == Integer.MAX_VALUE){
                return -1;
            }
            answer = Math.max(answer, dist[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        NetworkDelayTime ndt = new NetworkDelayTime();
        int ans = ndt.networkDelayTime(new int[][]{{2,1,1},{2,3,1},{3,4,1}},4,2);
        System.out.println(ans);
    }

}
