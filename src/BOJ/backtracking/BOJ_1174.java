package BOJ.backtracking;
import java.util.*;
import java.io.*;
public class BOJ_1174 {
    static int N;
    static String[] num = { "9", "8", "7", "6", "5", "4", "3", "2", "1", "0" };
    static List<Long> list;

    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        list = new ArrayList<Long>();
        go("0",0);


        Collections.sort(list);
        if(list.size() < N){
            System.out.println(-1);
        }else{
            System.out.println(list.get((N-1)));
        }
    }

    private static void go(String str,int idx) {
        if(idx == 10){

            if(!list.contains(Long.parseLong(str))){
                list.add(Long.parseLong(str));
            }
            return;
        }
        go(str + num[idx % 10], idx + 1); //선택 한 경우의 수
        go(str, idx + 1); //선택 한 경우의 수
    }
}