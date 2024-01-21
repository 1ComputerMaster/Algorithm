package BOJ.Data_Structure;
import java.io.*;
import java.util.*;
public class BOJ_10828 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk  = new StringTokenizer(in.readLine()," ");
        int N = Integer.parseInt(tk.nextToken());
        int stack[] = new int[N];
        int size = 0;
        for(int i = 0; i < N; i++){
            tk  = new StringTokenizer(in.readLine()," ");
            String str = tk.nextToken();
            if("push".equals(str)){
                stack[size++] = Integer.parseInt(tk.nextToken());
            }
            if("top".equals(str)){
                if(size == 0){
                    System.out.println(-1);
                }else{
                    System.out.println(stack[size - 1]);
                }
            }
            if("size".equals(str)){
                System.out.println(size);
            }
            if("pop".equals(str)){
                if(size == 0){
                    System.out.println(-1);
                }else{
                    System.out.println(stack[size - 1]);
                    stack[size - 1] = 0;
                    size--;
                }
            }
            if("empty".equals(str)){
                if(size == 0){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }
        }
    }
}
