package BOJ.disjoint_set;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_4195 {
    static int[] parent;
    static int[] size;
    static Map<String, Integer> friendMap;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");

        int T = Integer.parseInt(tk.nextToken());
        while(T-- > 0) {
            parent = new int[200002]; // 충분히 큰 크기로 배열 초기화
            size = new int[200002];
            for (int i = 1; i <= 200001; i++) {
                parent[i] = i;
                size[i] = 1;
            }

            friendMap = new HashMap<String, Integer>();
            int cnt = 0;
            tk = new StringTokenizer(in.readLine(), " ");
            int N = Integer.parseInt(tk.nextToken());
            for (int i = 0; i < N; i++) {
                tk = new StringTokenizer(in.readLine(), " ");
                String friend = tk.nextToken();
                String otherFriend = tk.nextToken();
                if (friendMap.getOrDefault(friend, -1) == -1) {
                    friendMap.put(friend, ++cnt);
                }
                if (friendMap.getOrDefault(otherFriend, -1) == -1) {
                    friendMap.put(otherFriend, ++cnt);
                }
                union(friend, otherFriend);
                int rootA = find(friendMap.get(friend));
                System.out.println(size[rootA]);
            }
        }
    }

    private static void union(String friend, String otherFriend) {
        int rootA = find(friendMap.get(friend));
        int rootB = find(friendMap.get(otherFriend));

        if(rootA != rootB){
            if(size[rootA] > size[rootB]){
                parent[rootB] = parent[rootA];
                size[rootA] += size[rootB];
            }
            else {
                parent[rootA] = parent[rootB];
                size[rootB] += size[rootA];
            }
        }
    }

    private static int find(int a) {
        if(parent[a] == a){
            return a;
        }
        return parent[a] = find(parent[a]);
    }
}
