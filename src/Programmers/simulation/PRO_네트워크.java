package simulation;

public class PRO_네트워크 {//내가 현 위치에서 갈 수 있는 곳을 모두 체크하자
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean visited[] = new boolean[n];
        for(int i = 0; i < n; i++){
            if(visited[i] == false){//행의 위치
                dfs(i,visited,computers);
                answer++;
            }
        }
        return answer;
    }
    private static void dfs(int y, boolean[] visited,int[][] com){
        visited[y] = true; // 내 자신이 계속 도는 것을 방지한다.
        for(int i = 0; i < com.length; i++){
            if(com[y][i] == 1 && !visited[i]){
                dfs(i,visited,com);
            }
        }
    }
}
