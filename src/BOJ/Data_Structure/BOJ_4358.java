package BOJ.Data_Structure;

import java.io.*;
import java.util.*;

public class BOJ_4358 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Map<String,Double> map = new LinkedHashMap<String,Double>();
        double cnt = 0;
        while(true){
            String str = in.readLine();
            if(str == null){
                break;
            }
            cnt++;
            map.put(str,(map.getOrDefault(str,0.0) + 1.0));
        }
        List<String> keyList = new ArrayList<>(map.keySet());
        keyList.sort((s1, s2) -> s1.compareTo(s2));
        for (String key : keyList) {
            double ratio = (double) ((map.get(key)/cnt) * 100.0);
            System.out.println(key + " " + String.format("%.4f", ratio));
        }
    }
}
