package BOJ.tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_4256 {
    static int [] inOrder,preOrder;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");
        int T = Integer.parseInt(tk.nextToken());

        while (T-- > 0){
            tk = new StringTokenizer(in.readLine()," ");
            int N = Integer.parseInt(tk.nextToken());

            preOrder = new int[N];
            inOrder = new int [N];

            tk = new StringTokenizer(in.readLine()," ");
            for (int i = 0; i < N; i++){
                preOrder[i] = Integer.parseInt(tk.nextToken());
            }

            tk = new StringTokenizer(in.readLine()," ");
            for (int i = 0; i < N; i++){
                inOrder[i] = Integer.parseInt(tk.nextToken());
            }
            getRoot(0,N,0);
            System.out.println();
        }
    }
    private static void getRoot(int root,int right,int left){
        if(right <= left || right < 0){
            return;
        }
        int rootIdx = 0;
        for (int i = 0; i < inOrder.length; i++) {
            if (preOrder[root] == inOrder[i]) {
                rootIdx = i;
                getRoot(root + 1,rootIdx,left);
                getRoot(root + i + 1 - left , right,rootIdx + 1);
                System.out.print(inOrder[rootIdx] + " ");
            }
        }
    }
}