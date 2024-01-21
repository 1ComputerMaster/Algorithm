package BOJ.Data_Structure;
import java.util.*;
public class BOJ_9012 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Queue<Character> q;
        for(int i = 0; i < N; i++){
            boolean check = true;
            q = new LinkedList<>();
            String str = sc.next();
            char[] crr = str.toCharArray();
            for(char c : crr){
                if(!extracted(c, q)){
                    System.out.println("NO");
                    check = false;
                    break;
                }
            }
            if(!q.isEmpty()){
                System.out.println("NO");
            }else if (check){
                System.out.println("YES");
            }
        }
    }

    private static boolean extracted(char c, Queue<Character> q) {
        if(c == '('){
            q.add(c);
            return true;
        }else{
            if(q.isEmpty()){
                return false;
            }else{
                q.poll();
                return true;
            }
        }
    }
}
