package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
public class BOJ_5597 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> students = new ArrayList<Integer>();
        for (int i = 0; i < 28; i++){
            students.add(Integer.parseInt(in.readLine()));
        }
        for (int i = 1; i <= 30; i++){
            if(!students.contains(i)){
                System.out.println(i);
            }
        }
    }
}
