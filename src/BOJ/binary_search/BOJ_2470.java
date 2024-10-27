package BOJ.binary_search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2470 {
    /*
    * 접근 방식은 맞았으나 엣지 케이스 고려가 쉽지 않아서 많이 틀렸던 문제
    * */

    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(tk.nextToken());
        List<Integer> liquid = new ArrayList<>(); //용액
        tk = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++){
            liquid.add(Integer.parseInt(tk.nextToken()));
        }
        Collections.sort(liquid);
        int left = 0;
        int right = N - 1;
        int minLeft = 0;
        int minRight = N - 1;
        int ans = Integer.MAX_VALUE;
        while (left < right){
            if(liquid.get(left) + liquid.get(right) > 0) {
                if(Math.abs((liquid.get(left)) + (liquid.get(right))) < Math.abs(ans)){
                    minLeft = left;
                    minRight = right;
                    ans = liquid.get(left) + liquid.get(right);
                }
                right -= 1;
            }
            else if(liquid.get(left) + liquid.get(right) < 0){
                if(Math.abs((liquid.get(left)) + (liquid.get(right))) < Math.abs(ans)){
                    minLeft = left;
                    minRight = right;
                    ans = liquid.get(left) + liquid.get(right);
                }
                left += 1;
            }else {
                minLeft = left;
                minRight = right;
                break;
            }
        }
        System.out.println(liquid.get(minLeft) + " " + liquid.get(minRight));
    }
}
