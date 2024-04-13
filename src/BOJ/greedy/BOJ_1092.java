package BOJ.greedy;
import java.util.*;

public class BOJ_1092 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> crane = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            crane.add(sc.nextInt());
        }

        int M = sc.nextInt();
        List<Integer> box = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            box.add(sc.nextInt());
        }

        Collections.sort(crane, Collections.reverseOrder());
        Collections.sort(box, Collections.reverseOrder());

        if (crane.get(0) < box.get(0)) {
            System.out.println(-1);
            return;
        }

        int count = 0;

        while(!box.isEmpty()){
            int idx = 0;
            for(int i = 0 ; i < crane.size(); i++){
                if(idx == box.size()) break;
                else if(crane.get(i) >= box.get(idx))
                    box.remove(idx);
                else{
                    idx++;
                    i--;
                }
            }
            count++;
        }
        System.out.println(count);
    }
}
