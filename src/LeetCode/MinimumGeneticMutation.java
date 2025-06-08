package LeetCode;

import java.util.*;

public class MinimumGeneticMutation {
    public static void main(String[] args) {
        System.out.println(minMutation("AACCGGTT", "AAACGGTA"
                , new String[]{"AACCGGTA","AACCGCTA","AAACGGTA"}));
    }
    public static int minMutation(String startGene, String endGene, String[] bank) {
        Queue<String> q = new LinkedList<>();
        Set<String> vis = new HashSet<>();
        List<String> banks = Arrays.asList(bank);
        int steps = 0;

        q.add(startGene);

        while (!q.isEmpty()){
            int initQueueSize = q.size();
            for (int i = 0; i < initQueueSize; i++) {
                String s = q.poll();
                if(s.equals(endGene)){
                    return steps;
                }
                char[] ca = s.toCharArray();
                for (int j = 0; j < ca.length; j++) {
                    char oa = ca[j];
                    for (int k = 0; k < 4; k++) {
                        ca[j] = "ACGT".charAt(k);
                        String t = new String(ca);
                        if (!vis.contains(t) && banks.contains(t)) {
                            q.add(t);
                            vis.add(t);
                        }
                    }
                    ca[j] = oa;
                }
            }
            steps++;
        }
        return -1;
    }

}
