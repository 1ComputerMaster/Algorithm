package BOJ.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_11365 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String str = in.readLine();
            if("END".equals(str)){
                break;
            }
            else{
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                System.out.println(sb.reverse());
            }
        }
    }
}
