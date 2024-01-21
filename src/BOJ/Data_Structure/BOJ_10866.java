package BOJ.Data_Structure;

import java.io.*;
import java.util.*;

public class BOJ_10866 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk  = new StringTokenizer(in.readLine()," ");
        int N = Integer.parseInt(tk.nextToken());
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            tk  = new StringTokenizer(in.readLine()," ");
            String str = tk.nextToken();
            if("push_front".equals(str)){
                list.add(0,Integer.parseInt(tk.nextToken()));
            }
            if("push_back".equals(str)){
                list.add(Integer.parseInt(tk.nextToken()));
            }
            if("pop_front".equals(str)){
                if(list.size() > 0) {
                    sb.append(list.get(0) + "\n");
                    list.remove(0);
                }else{
                    sb.append(-1 + "\n");
                }
            }
            if("pop_back".equals(str)){
                if(list.size() > 0) {
                    sb.append(list.get(list.size() - 1) + "\n");
                    list.remove(list.size() - 1);
                }else{
                    sb.append(-1 + "\n");
                }
            }
            if("size".equals(str)){
                sb.append(list.size() + "\n");
            }
            if("front".equals(str)){
                if(list.size() > 0) {
                    sb.append(list.get(0) + "\n");
                }else{
                    sb.append(-1 + "\n");
                }
            }
            if("back".equals(str)){
                if(list.size() > 0) {
                    sb.append(list.get(list.size() - 1) + "\n");
                }else{
                    sb.append(-1 + "\n");
                }
            }
            if("empty".equals(str)){
                if(list.size() == 0){
                    sb.append(1 + "\n");
                }else{
                    sb.append(0 + "\n");
                }
            }
        }
        System.out.print(sb.toString());
    }
}
