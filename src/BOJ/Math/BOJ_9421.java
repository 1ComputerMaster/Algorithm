package BOJ.Math;
import java.util.*;

public class BOJ_9421 {
    static Map<Integer,Integer> map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> list = getPrime(N);
        makeNum(list);
    }

    private static void makeNum(List<Integer> list) {
        for(int i = 0; i < list.size(); i++) {
            map = new HashMap<>();
            String str = String.valueOf(list.get(i));
            int num = 0;
            while(true) {
                num = 0;
                for (char c : str.toCharArray()) {
                    int n = c - '0';
                    if (n != 0) {
                        n = (int) Math.pow(n, 2);
                    }
                    num += n;
                }
                str = String.valueOf(num);
                map.put(num, map.getOrDefault(num, 0) + 1);
                if (map.get(num) > 1) {
                    break;
                }
                if (num == 1) {
                    System.out.println(list.get(i));
                    break;
                }
            }
        }
    }
    private static List<Integer> getPrime(int n) {

        List<Integer> list = new ArrayList<>();

        boolean check = false;
        for(int i = 2; i <= n; i++){
            check = false;
            for(int j = 2; j*j <= i; j++){
                if(i != j && i % j == 0){
                    check = true;
                    break;
                }
            }
            if(!check){
                list.add(i);
            }
        }
        return list;
    }
}
