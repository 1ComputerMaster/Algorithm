package BOJ.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());
        long D = Long.parseLong(st.nextToken());

        if (B * C > D * A) { // D/C > B/A ->  D / C * A > B -> D * A > B * C (가성비가 안 좋은 것을 선택)
            long priceA = B;
            B = D;
            D = priceA;
            long tmp = A;
            A = C;
            C = tmp;
        }

        long money = Long.MAX_VALUE;

        for (int i = 0; i < C; i++) {
            int j = 0;
            if(Math.ceil((double) (N - A * i) / C) >= 0){
                j = (int) Math.ceil((double)(N - A * i) / C);
            } else{
                break;
            }
            money = Math.min(money, i * B + j * D);

        }
        System.out.println(money);
    }
}