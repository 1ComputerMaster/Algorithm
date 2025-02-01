package BOJ.simulation;

import java.util.*;

public class BOJ_1713 {
    static class CandidatePriorityData implements Comparable<CandidatePriorityData>{
        int studentTime;
        int priority;
        int studentKey;

        public CandidatePriorityData(int studentTime, int priority, int studentKey){
            this.studentTime = studentTime;
            this.priority = priority;
            this.studentKey = studentKey;
        }
        @Override
        public int compareTo(CandidatePriorityData o) {
            if (this.priority != o.priority) {
                return Integer.compare(this.priority, o.priority); // priority 오름차순
            } else {
                return Integer.compare(this.studentTime, o.studentTime); // studentTime 오름차순
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int studentCnt = sc.nextInt();
        Map<Integer, Integer> studentTimeMap = new HashMap<>();
        Map<Integer, Integer> priorityMap = new HashMap<>();
        PriorityQueue<CandidatePriorityData> candidatePriorityQueue = new PriorityQueue<>();
        for (int i = 0; i < studentCnt; i++){
            int studentKey = sc.nextInt();
            if(studentTimeMap.containsKey(studentKey)){
                // 기존 데이터 업데이트
                int newPriority = priorityMap.get(studentKey) + 1;
                priorityMap.put(studentKey, newPriority);
                // 기존 요소 제거
                candidatePriorityQueue.removeIf(data -> data.studentKey == studentKey);
                // 새로운 요소 추가
                candidatePriorityQueue.add(new CandidatePriorityData(studentTimeMap.get(studentKey), newPriority, studentKey));
            }else{
                if (candidatePriorityQueue.size() >= N) {
                    CandidatePriorityData removed = candidatePriorityQueue.poll();
                    priorityMap.remove(removed.studentKey);
                    studentTimeMap.remove(removed.studentKey);
                }
                studentTimeMap.put(studentKey, i); // studentTime 업데이트
                priorityMap.put(studentKey, 1);
                candidatePriorityQueue.add(new CandidatePriorityData(i, 1, studentKey));
            }
        }
        List<Integer> list = new ArrayList<>();
        while (!candidatePriorityQueue.isEmpty())
        {
            list.add(candidatePriorityQueue.poll().studentKey);
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
    }
}
