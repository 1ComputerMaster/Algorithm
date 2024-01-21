package BOJ.Data_Structure;
import java.io.*;
import java.util.*;
public class BOJ_18258 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk  = new StringTokenizer(in.readLine()," ");
        int N = Integer.parseInt(tk.nextToken());
        int queue[] = new int[N];
        int back = 0;
        int front = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            tk  = new StringTokenizer(in.readLine()," ");
            String str = tk.nextToken();
            if("push".equals(str)){
                queue[back++] = Integer.parseInt(tk.nextToken());
            }
            if("front".equals(str)){
                if(queue[front] == 0){
                    sb.append(-1 + "\n");
                }else {
                    sb.append(queue[front] + "\n");
                }
            }
            if("back".equals(str)){
                if((back - 1) < 0){
                    sb.append(-1 + "\n");
                }else {
                    if(queue[back - 1] == 0){
                        sb.append(-1 + "\n");
                    }else {
                        sb.append(queue[back - 1] + "\n");
                    }
                }
            }
            if("size".equals(str)){
                sb.append(back - front +"\n");
            }
            if("pop".equals(str)){
                if(queue[front] == 0){
                    sb.append(-1 + "\n");
                }else{
                    sb.append(queue[front] + "\n");
                    queue[front] = 0;
                    front++;
                }
            }
            if("empty".equals(str)){
                if(back - front == 0){
                    sb.append(1 + "\n");
                }else{
                    sb.append(0 + "\n");
                }
            }
        }
        System.out.print(sb.toString());
    }
}
