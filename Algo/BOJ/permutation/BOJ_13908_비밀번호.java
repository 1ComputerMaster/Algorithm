package permutation;
import java.util.*;

public class BOJ_13908_비밀번호 {
	/*
	 * 결국 순조부 문제
	 * 순열로 쓴 이유는 순서가 중요하므로 
	 * 그리고 또한, 10개 중에 이미 1~2개 뽑아 놓고 만든다고 생각하면 된다.
	 * 허나 일반적인 백트레킹은 하면 안되고 이미 뽑은 것을 선택 하는 것으로 만들어야 한다.
	 * */
    static int n, m;
    static int count;
    static boolean[] visited;
 
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);

    	n= sc.nextInt();
    	m= sc.nextInt();
        visited = new boolean[10];
        for(int i = 0; i < m; i++) {
            visited[sc.nextInt()] = true;
        }
 
        backtracking(0, 0);
        System.out.println(count);
    }
    public static void backtracking(int idx, int cnt) {
        if(idx == n) { //10개 다 왔고 그 때
            if(cnt == m) 
            	count++; // 2개나 내가 지정한곳 까지만 왔다면...
            return;
        }
        for(int i = 0; i <= 9; i++) {
            if(visited[i]) {
                visited[i] = false;
                backtracking(idx + 1, cnt + 1);
                visited[i] = true;
            } else {
                backtracking(idx + 1, cnt);
            }
        }
    }
}
 