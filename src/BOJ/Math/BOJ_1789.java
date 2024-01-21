package BOJ.Math;
import java.io.*;
public class BOJ_1789 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(in.readLine());
        long ans = 0;
        for(long i = 0; i < 100000; i++){
            if(((i*(i+1))/2) > S){
                ans = i-1;
                break;
            }
        }
        System.out.println(ans);
    }
}
