package BOJ.Divide;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class BOJ_17829 {
    static int[][] map;

    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine(), " ");
        int N = Integer.parseInt(tk.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++){
            tk = new StringTokenizer(in.readLine(), " ");
            for (int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(tk.nextToken());
            }
        }
        System.out.println(divideAndPool(0, 0, N));
    }

    private static int divideAndPool(int x, int y, int size) {
        if (size == 1) {
            return map[x][y];
        }

        int newSize = size / 2;
        int[] poolValues = new int[4];

        poolValues[0] = divideAndPool(x, y, newSize);
        poolValues[1] = divideAndPool(x, y + newSize, newSize);
        poolValues[2] = divideAndPool(x + newSize, y, newSize);
        poolValues[3] = divideAndPool(x + newSize, y + newSize, newSize);

        //내림차순
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int val : poolValues) {
            pq.add(val);
        }

        pq.poll();
        return pq.poll();
    }
}