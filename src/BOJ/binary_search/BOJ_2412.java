package BOJ.binary_search;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2412 {
    static int N, T;
    static ArrayList<Integer>[] points;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine(), " ");
        N = Integer.parseInt(tk.nextToken());
        T = Integer.parseInt(tk.nextToken());
        points = new ArrayList[20001];
        for (int i = 0; i < 20001; i++){
            points[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(in.readLine(), " ");
            int x = Integer.parseInt(tk.nextToken());
            int y = Integer.parseInt(tk.nextToken());
            points[y].add(x);
        }
        for (int i = 0; i < 20001; i++)
            Collections.sort(points[i]);

        int result = bfs();
        System.out.println(result);
    }

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        int steps = 0;
        queue.add(new int[] {0,0});
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int[] cur = queue.poll();
                int cx = cur[0], cy = cur[1];
                if (cy == T) return steps; // 정상 도착 시 반환
                for (int y = cur[1] - 2; y <= cur[1] + 2; y++) {
                    if (y < 0 || y >= 20001) continue;
                    for (int j = 0; j < points[y].size(); j++) {
                        int x = points[y].get(j);
                        if (cx + 2 < x) break;
                        else if (cx - 2 > x) continue;
                        points[y].remove(j);
                        queue.add(new int[]{x, y});
                        j--;
                    }
                }
            }
            steps++;
        }

        return -1; // 정상 도달 불가 시 -1 반환
    }
}