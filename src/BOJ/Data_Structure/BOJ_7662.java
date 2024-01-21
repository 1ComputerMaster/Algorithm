package BOJ.Data_Structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ_7662 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine(), " ");
        int T = Integer.parseInt(tk.nextToken());
        TreeMap<Integer,Integer> map;
        while(T-- > 0){
            map = new TreeMap<>();
            tk = new StringTokenizer(in.readLine(), " ");
            int N = Integer.parseInt(tk.nextToken());
            while(N-- > 0){
                tk = new StringTokenizer(in.readLine(), " ");

                String str = tk.nextToken();

                int n = Integer.parseInt(tk.nextToken());

                if(str.equals("I")){
                    map.put(n, map.getOrDefault(n, 0) + 1);
                }else if (str.equals("D") && !map.isEmpty()){
                    if(n == -1) {
                    int minKey = map.firstKey();
                    if (map.get(minKey) == 1)
                    {
                        map.remove(minKey);
                    }else{
                        map.put(minKey,map.get(minKey)-1);
                    }
                    }else {
                        int maxKey = map.lastKey();
                        if (map.get(maxKey) == 1)
                        {
                            map.remove(maxKey);
                        }else{
                            map.put(maxKey,map.get(maxKey)-1);
                        }

                    }
                }
            }
            if (map.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(map.lastKey() + " " + map.firstKey());
            }
        }
    }
}
