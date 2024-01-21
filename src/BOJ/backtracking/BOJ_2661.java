package BOJ.backtracking;
import java.io.*;
import java.util.*;
public class BOJ_2661 {
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");

        N = Integer.parseInt(tk.nextToken());
        go(0,"");
    }

    public static void go(int idx,String str){
        if(idx == N){
            if(check(str)){
                System.out.println(str);
                System.exit(0);
            }
            return;
        }
        for(int i = 1; i <= 3; i++){
            if(check(str  + (i + ""))) {
                go(idx + 1, str + (i + ""));
            }
        }
    }
    public static boolean check(String str){
        for(int i = 1; i <= str.length()/2; i++) {
            String front = str.substring(str.length()-i*2, str.length()-i);
            String back = str.substring(str.length()-i);

            if(front.equals(back)) return false;
        }

        return true;
    }
}
