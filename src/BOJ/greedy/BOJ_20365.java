package BOJ.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_20365 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        String str = in.readLine();
        int Bcnt = 0;
        int Acnt = 0;
        List<Integer> aList = new ArrayList<>();
        List<Integer> bList = new ArrayList<>();

        for (int i = 0; i < N; i++){
            if(str.charAt(i) == 'B'){
                Bcnt++;
                if(i - 1 >= 0 && str.charAt(i - 1) == 'B'){
                    int bIdx = (bList.size() - 1);
                    bList.set(bIdx,bList.get(bIdx) + 1);
                }else{
                    bList.add(1);
                }
            }else{
                Acnt++;
                if(i - 1 >= 0 && str.charAt(i - 1) == 'R'){
                    int aIdx = (aList.size() - 1);
                    aList.set(aIdx,aList.get(aIdx) + 1);
                }else{
                    aList.add(1);
                }
            }
        }
            System.out.println(Math.min(1 + bList.size(), 1 + aList.size()));
    }
}
