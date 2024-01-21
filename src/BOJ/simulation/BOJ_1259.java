package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1259 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        while (true){
            sb = new StringBuilder();
            String str = in.readLine();
            if(str.equals("0")){
                break;
            }
            if(sb.append(str).reverse().toString().equals(str))
            {
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }
    }
}
