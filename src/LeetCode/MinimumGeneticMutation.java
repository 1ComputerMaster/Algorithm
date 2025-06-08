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
            for (int i = q.size(); i > 0; i--) {
                String s = q.poll();
                if(s.equals(endGene))
                    return steps;
                //changed voca
                char[] ca = s.toCharArray();
                for (int j = 0; j < endGene.length(); j++) {
                    char oc = ca[j];
                    for (int k = 0; k < 4; k++){
                        ca[j] = "ACGT".charAt(k);
                        //재검증 시기에 ca[j]를 돌려 놓지 않으면 문제가 된다.
                        String t = new String(ca);
                        if (!vis.contains(t) && banks.contains(t)) {
                            // push the next node to the queue
                            q.add(t);
                            // and mark it visited
                            vis.add(t);
                        }
                    }
                    //revart to since changed
                    ca[j] = oc;
                }
            }
            steps++;
        }
        return -1;
    }
}
