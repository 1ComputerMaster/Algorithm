package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
    public static void main(String[] args) {
        CourseSchedule cs = new CourseSchedule();
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        System.out.println(cs.canFinish(numCourses, prerequisites)); // Should return true
    }
    static int[] visited;
    static List<Integer>[] graph;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses]; // 0 : 초기, 1 : 방문 중, 2 : 방문 완료
        graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<>();
        }

        for (int[] pre : prerequisites) {
            graph[pre[1]].add(pre[0]);
        }

        for(int i = 0; i < numCourses; i++){
            if(visited[i] == 0){
                if(dfs(i) == false){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean dfs(int u){
        if(visited[u] == 1) return false;
        if(visited[u] == 2) return true;

        visited[u] = 1;
        for(int v : graph[u]){
            if(visited[v] == 1) return false;
            if(!dfs(v)){
                return false;
            }
        }
        visited[u] = 2;
        return true;
    }
}
