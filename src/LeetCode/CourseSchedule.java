package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public static void main(String[] args) {
        CourseSchedule cs = new CourseSchedule();
        int numCourses = 2;
        int[][] prerequisites = {{1, 0},{0,1}};
        System.out.println(cs.canFinish(numCourses, prerequisites)); // Should return true
    }
    static List<Integer>[] graph;
    static int[] state; // 0 = 미방문, 1 = 방문중, 2 = 방문완료

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 1 || prerequisites.length == 0)
            return true;

        graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList<>();

        // 인접 리스트 구성
        for (int[] pre : prerequisites) {
            int from = pre[1];
            int to = pre[0];
            graph[from].add(to);
        }

        state = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0 && hasCycle(i))
                return false; // 사이클 있으면 수강 불가
        }
        return true;
    }

    private boolean hasCycle(int node) {
        if (state[node] == 1) return true;  // 방문 중 → 사이클
        if (state[node] == 2) return false; // 이미 완료 → OK

        state[node] = 1; // 방문 중
        for (int next : graph[node]) {
            if (hasCycle(next))
                return true;
        }
        state[node] = 2; // 방문 완료
        return false;
    }
}
