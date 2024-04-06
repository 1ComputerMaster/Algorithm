package BOJ.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_21314 {
    /**
     * MKM = 501/151
     * MKKMMK = 505500/155105
     *
     * MAX를 만드는 방법 -> MMK 이면 K가 K 전의 M까지 파악해서 그 위치에 5를 둔다. (만일, 바로 앞이 K이면 5를 지금 K 위치에 박는다.)
     * ->그 후 나머지 MM은 00으로 처리가 된다. (만일, 이때 마지막 숫자가 M이면 거기에 1을 둠)
     *
     * MIN을 만드는 방법 :
     * K는 현재 위치에서 바로 5를 박고 끝자리의 M은 모두 1으로 처리가 된다.
     * -> 000000으로 만들고 거기서 만들자.
     * @param args
     * @throws Exception
     */

    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = in.readLine();

        char[] maxCrr = new char[str.length()];
        char[] minCrr = new char[str.length()];
        visited = new boolean[str.length()];
        for (int i = 0; i < str.length(); i++){
            minCrr[i] = '0';
            maxCrr[i] = '0';
        }

        getMaxCrr(str, maxCrr);
        getMinCrr(str, minCrr);
        System.out.println(maxCrr);
        System.out.println(minCrr);
    }

    private static void getMaxCrr(String str, char[] maxCrr) {
        boolean check = false;
        for (int i = 0; i < str.length(); i++){
            if(str.charAt(i) == 'K'){
                check = true;
                getFirstK(maxCrr, str,i);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            if(!visited[i] && maxCrr[i] == '0') {
                maxCrr[i] = '1';
            }
        }

        if(!check){
            for (int i = 0; i < str.length(); i++) {
                maxCrr[i] = '1';
            }
        }
    }
    private static void getFirstK(char[] maxCrr, String str, int idx) {
        visited[idx] = true;
        for (int i = idx - 1; i >= 0; i--){
            visited[i] = true;
            if(str.charAt(i) == 'K'){
                maxCrr[i + 1] = '5';
                return;
            }
        }
        maxCrr[0] = '5';
    }

    private static void getMinCrr(String str, char[] minCrr) {
        for (int i = 0; i < str.length(); i++){
            if(str.charAt(i) == 'K'){
                minCrr[i] = '5';
            }
            if(i - 1 >= 0 && str.charAt(i - 1) == 'K' && str.charAt(i) == 'M'){
                minCrr[i] = '1';
            }
        }
        if(str.charAt(0) == 'M'){
            minCrr[0] = '1';
        }
    }
}

