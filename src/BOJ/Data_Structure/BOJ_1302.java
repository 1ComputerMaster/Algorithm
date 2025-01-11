package BOJ.Data_Structure;

import java.io.*;
import java.util.*;

public class BOJ_1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(in.readLine());
        Map<String, Integer> nameCountMap = new HashMap<>();
        for (int i = 0; i < N ; i++){
            String name = in.readLine();
            nameCountMap.put(name, nameCountMap.getOrDefault(name, 0) + 1);
        }
        int max = Collections.max(nameCountMap.values());
        List<String> names = new ArrayList<>();
        for (String key : nameCountMap.keySet()){
            if(nameCountMap.get(key) == max){
                names.add(key);
            }
        }
        Collections.sort(names);
        bw.write(names.get(0));
        bw.flush();
        bw.close();

    }
}
