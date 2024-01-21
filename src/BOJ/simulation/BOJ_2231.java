package BOJ.simulation;
import java.util.*;
public class BOJ_2231 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for(int i = 1; i < N; i++){
            String str = String.valueOf(i);

            char [] crr = str.toCharArray();
            int tmp = i;
            for(char c : crr){
                    tmp += (c - '0');
            }
            if(tmp == N){
                System.out.println(str);
                return;
            }
        }
        System.out.println(0);
    }
}
