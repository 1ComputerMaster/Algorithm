package BOJ.two_pointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 조건
 * R로만 이루어진 문자열은 ㅋㅋ루ㅋㅋ 문자열이다. 단, 빈 문자열은 ㅋㅋ루ㅋㅋ 문자열이 아니다.
 * ㅋㅋ루ㅋㅋ 문자열 양 끝에 K를 하나씩 붙인 문자열은 ㅋㅋ루ㅋㅋ 문자열이다.
 *
 * 부분 수열으로 더해지는 것을 생각을 하고 풀어야 이해가 되는 문제다. 처음 이해 자체가 되지 않아서 무슨 문제인지 파악하는 것이 어려웠다.
 *
 * 'R' KK 'R' KKKK 'R' KKK 'R' KKK
 * (right - left + 1) 가운데 있는 R의 갯수가 맞다.
 *  - R의 갯수는 이미 지나쳐 온 오른쪽 k 사이즈에서 그 만큼 left 사이즈 만큼 뺀 것이다. 왜냐하면 R의 갯수가 나온 만큼 K 갯수를 넣었으니깐
 *  - 그리고 나의 R 갯수 하나를 더한다.
 * KKKRKK 일 경우 KK 최소 값이 먼저 선택이 되고 이때 선택된 값이 R을 선택해서 같은 값으로 간다
 * KKK RKRRKRKRKR KRKK 일때, K 갯수가 3이고 여기서 중간의 R은 제외되어서 보여야 한다.
 *
 *
 * */

public class BOJ_20442 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int max = solved(input);
        System.out.println(max); // 양쪽 끝의 K가 각각 한 번씩 포함됨
    }

    private static int solved(String input) {
        int length = input.length();
        List<Integer> lK = new ArrayList<>();
        List<Integer> rK = new ArrayList<>();
        int lc = 0;
        for(int i = 0; i < length; i++){
            if(input.charAt(i) == 'R'){
                lK.add(lc);
            }
            else{
                lc++;
            }
        }
        int rc = 0;
        for(int i = length - 1; i >= 0; i--){
            if(input.charAt(i) == 'R'){
                rK.add(rc);
            }
            else{
                rc++;
            }
        }
        reverseOrder(rK);
        int left = 0;
        int right = rK.size() - 1;
        int max = 0;
        while(left <= right){

            int padding = Math.min(lK.get(left),rK.get(right)) * 2;
            max = Math.max(padding + (right - left + 1), max);
            if(lK.get(left) > rK.get(right)){
                right--;
            }else{
                left++;
            }
        }
        return max;
    }
    private static void reverseOrder(List<Integer> list){
        Stack<Integer> st = new Stack<>();
        for (int c : list){
            st.push(c);
        }
        list.clear();
        while (!st.isEmpty()){
            list.add(st.pop());
        }
    }
}