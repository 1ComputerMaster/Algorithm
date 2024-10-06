package BOJ.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_10815 {

    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");

        solutionByBinarySearch(tk, in);

//        solutionByHashMap(tk, in);
    }

    private static void solutionByBinarySearch(StringTokenizer tk, BufferedReader in) throws IOException {
        int N = Integer.parseInt(tk.nextToken());
        tk = new StringTokenizer(in.readLine()," ");
        List<Integer> cardCheckList = new ArrayList<>();

        for (int i = 0; i < N; i++){
            cardCheckList.add(Integer.parseInt(tk.nextToken()));
        }
        Collections.sort(cardCheckList);

        tk = new StringTokenizer(in.readLine()," ");
        int M = Integer.parseInt(tk.nextToken());
        StringBuilder sb = new StringBuilder();
        tk = new StringTokenizer(in.readLine()," ");
        for (int i = 0; i < M; i++){
            binarySearch(Integer.parseInt(tk.nextToken()), sb, cardCheckList);
        }
        System.out.println(sb.toString());

    }

    private static void binarySearch(int findNum, StringBuilder sb, List<Integer> cardCheckList) {
        int left = 0;
        int right = cardCheckList.size() - 1;
        boolean check = false;
        while(left <= right){
            int mid = (right + left) / 2;
            if(cardCheckList.get(mid) == findNum){
                check = true;
                break;
            }
            if(cardCheckList.get(mid) > findNum){
                right = mid - 1;
            }
            if(cardCheckList.get(mid) < findNum){
                left = mid + 1;
            }
        }
        if(check){
            sb.append(1+ " ");
        }else{
            sb.append(0+ " ");
        }
    }


    /*
     * HashMap 풀이
     * - O(1)으로 바로 찾는다.
     * */
    private static void solutionByHashMap(StringTokenizer tk, BufferedReader in) throws IOException {
        int N = Integer.parseInt(tk.nextToken());
        Map<Integer, Integer> cardCheckMap = new HashMap<>();
        tk = new StringTokenizer(in.readLine()," ");
        for (int i = 0; i < N; i++){
            cardCheckMap.put(Integer.parseInt(tk.nextToken()),1);
        }
        tk = new StringTokenizer(in.readLine()," ");
        int M = Integer.parseInt(tk.nextToken());
        tk = new StringTokenizer(in.readLine()," ");
        for (int i = 0; i < M; i++){
            System.out.print(cardCheckMap.getOrDefault(Integer.parseInt(tk.nextToken()), 0) + " ");
        }
    }
}
