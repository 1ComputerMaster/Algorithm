package BOJ.Data_Structure;

import java.util.*;

public class BOJ_1966 {
    static class Data implements Comparable<Data>{
        int idx;
        int weight;
        public Data (int idx, int weight){
            this.idx = idx;
            this.weight = weight;
        }

        @Override
        public int compareTo(Data o) {
            if(o.weight > this.weight){
                return 1;
            }else if(o.weight < this.weight){
                return -1;
            }else{
                return 0 ;
            }
        }
    }
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 0; t < T; t++) {
            Queue<Data> q = new LinkedList<>();
            List<Data> list = new ArrayList<>();
            int N = sc.nextInt();
            int order = sc.nextInt();

            for(int i = 0; i < N; i++){
                int num = sc.nextInt();
                list.add(new Data(i,num));
                q.offer(new Data(i,num));
            }
            Collections.sort(list);
            int cnt = 0;
            while(true){

                Data num = q.poll();
                if(num.weight == list.get(0).weight){
                    cnt++;
                    list.remove(0);
                    if(num.idx == order){
                        System.out.println(cnt);
                        break;
                    }
                    Collections.sort(list);
                }else{
                    q.offer(num);
                }
            }
        }
    }
}
