package BOJ.Data_Structure;
import java.util.*;

public class BOJ_1620 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        Map<String,Integer> map = new LinkedHashMap<>();
        Map<Integer,String> numMap = new LinkedHashMap<>();

        for(int i = 0; i < N; i++){
            String str = sc.next();
            map.put(str,i+1);
            numMap.put(i+1,str);
        }
        for(int i = 0; i < M; i++){
            String str = sc.next();
            if(isInteger(str)){
                System.out.println(numMap.get(Integer.parseInt(str)));
            }else{
                System.out.println(map.get(str));
            }
        }
    }
    public static boolean isInteger(String strValue) {
        try {
            Integer.parseInt(strValue);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
