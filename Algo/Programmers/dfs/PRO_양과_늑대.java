package dfs;
import java.util.*;
public class PRO_양과_늑대 {
    static int ans;
    static ArrayList<Integer> graph[];
    static int[] node;
    
    public static void main(String[] args) {
		System.out.println(solution(new int[]{0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0}, new int[][]{{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}, {3, 7}, {4, 8}, {6, 9}, {9, 10}}));
	}
    
    @SuppressWarnings("unchecked")
	public static int solution(int[] info, int[][] edges) {
        int answer = 0;
        node = info.clone();
        ans = 0;
        boolean[] visited = new boolean[info.length];
        graph = new ArrayList[info.length];
        for(int i = 0; i < info.length; i++){
            graph[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < edges.length; i++){
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }
        dfs(0,0,0,visited);
        answer = ans;
        return answer;
    }
    public static void dfs(int num, int sheep, int wolf, boolean[] list) {
        // 양이면 양의 수 추가 
        if(node[num] == 0) {
            sheep++;
        }
        
        // 늑대라면 늑대의 수 추가 
        else if(node[num] == 1) {
            wolf++;
        }
        
        // 늑대가 양보다 많거나 같을 경우 종료 
        if(wolf>=sheep) {
            return;
        }

        // 방문체크용 배열을 깊은 복사(주소가 아닌 값 복사)
        boolean[] newList = list.clone();
        newList[num] = true;
        
        // 기록된 양의 최대 수 보다 많을 경우 갱신 
        ans = Math.max(ans, sheep);

        for(int i=0; i<newList.length; i++) {
            // 방문한 노드에서 갈 수 있는 곳 확인 
            if(newList[i] == true) {
                // 방문한 노드와 인접한 노드 체크 
                for(int j=0; j<graph[i].size(); j++) {
                    int temp = graph[i].get(j);

                    // 이미 갔던 곳은 안 가도록(새로운 곳만) 
                    if(newList[temp] == false) {
                        dfs(temp, sheep, wolf, newList);
                    }
                }
            }
        }
    }
}
