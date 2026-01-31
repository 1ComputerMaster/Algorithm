package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CoursewSchedule2 {
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        CoursewSchedule2 cs2 = new CoursewSchedule2();
        int[] order = cs2.findOrder(numCourses, prerequisites);
        for (int course : order) {
            System.out.print(course + " ");
        }
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<Integer>[] graph = new ArrayList[numCourses + 1];
        for (int i = 0; i <= numCourses; i++){
            graph[i] = new ArrayList<>();
        }


        for (int[] pre : prerequisites){
            int from = pre[1];
            int to = pre[0];
            inDegree[to]++;
            graph[from].add(to);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }

        int[] ans = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()){
            int curr = queue.poll();
            ans[index++] = curr;
            for (int neighbor : graph[curr]){
                inDegree[neighbor]--;
                if(inDegree[neighbor] == 0){
                    queue.offer(neighbor);
                }
            }
        }
        if(index != numCourses){
            return new int[0];
        }
        return ans;
    }
}
