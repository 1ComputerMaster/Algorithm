package LeetCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluateDivision {
    public static void main(String[] args) {
        EvaluateDivision ed = new EvaluateDivision();
        List<List<String>> equations = List.of(List.of("a", "b"), List.of("b", "c"), List.of("bc", "cd"));
        double[] values = {1.5, 2.5, 5.0};
        List<List<String>> queries = List.of(List.of("a", "c"), List.of("b", "a"), List.of("bc", "cd"), List.of("cd", "bc"));
        double[] results = ed.calcEquation(equations, values, queries);
        for (double result : results) {
            System.out.println(result);
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // 1) 변수마다 고유 인덱스 배정
        int idx = 0;
        Map<String, Integer> idMap = new HashMap<>();
        for (List<String> eq : equations) {
            for (String var : eq) {
                if (!idMap.containsKey(var)) {
                    idMap.put(var, idx++);
                }
            }
        }
        int n = idx;
        double[][] map = new double[n][n];
        // 자기 자신 비율 = 1
        for (int i = 0; i < n; i++) {
            map[i][i] = 1.0;
        }



        for (int k = 0; k < equations.size(); k++) {
            List<String> eq = equations.get(k);
            int u = idMap.get(eq.get(0));
            int v = idMap.get(eq.get(1));
            double w = values[k];
            map[u][v] = w;
            map[v][u] = 1.0 / w;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (map[i][k] == 0) continue; // 연결 없으면 건너뜀
                for (int j = 0; j < n; j++) {
                    if (map[k][j] == 0) continue;
                    if(map[i][j] == 0)
                    {
                        map[i][j] = (map[i][k] * map[k][j]);
                    }
                }
            }
        }

        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> q = queries.get(i);
            String a = q.get(0), b = q.get(1);
            if (!idMap.containsKey(a) || !idMap.containsKey(b)) {
                ans[i] = -1.0;
            } else {
                double val = map[idMap.get(a)][idMap.get(b)];
                ans[i] = (val == 0 ? -1.0 : val);
            }
        }

        return ans; // Placeholder return statement
    }
}
