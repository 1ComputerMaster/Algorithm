package BOJ.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11723_집합 {
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tk = new StringTokenizer(in.readLine(), " ");

        int M = Integer.parseInt(tk.nextToken());

        String token = "";

        int S = 0;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < M; i++){
            tk = new StringTokenizer(in.readLine(), " ");
            token = tk.nextToken();

            if(token.equals("all")){
                S = (1 << 21) - 1;
            }
            else if(token.equals("empty")){
                S = 0;
            }else{
                int num = Integer.parseInt(tk.nextToken());
                if(token.equals("add")){
                    S |= (1 << num);
                }else if(token.equals("remove")){
                    int temp = 1 << num;
                    temp = ~temp;
                    S &= temp; 
                }else if(token.equals("check")){
                    int temp = 1 << num;
                    if((S & temp) != 0){
                        sb.append(1).append("\n");
                    }else{
                        sb.append(0).append("\n");
                    }
                }else if(token.equals("toggle")){
                    int temp = 1 << num;
                    S^=temp;
                }
            }
        }
        System.out.println(sb);
    }
}
