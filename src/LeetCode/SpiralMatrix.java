package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        SpiralMatrix spiralMatrix = new SpiralMatrix();
        List<Integer> result = spiralMatrix.spiralOrder(matrix);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length - 1;
        int m = matrix[0].length - 1;
        List<Integer> ansList = new ArrayList<>();
        dfs(matrix, 0, n, 0, m, ansList);
        return ansList;
    }
    private void dfs(int[][] matrix, int x, int x1, int y, int y1, List<Integer> ansList){
        if(x > x1 || y > y1){
            return;
        }

        for(int j = y; j <= y1; j++){
            ansList.add(matrix[x][j]);
        }

        for(int i = x + 1; i <= x1; i++){
            ansList.add(matrix[i][y1]);
        }
        if (x < x1) {
            for(int j = y1 - 1; j >= y; j--){
                ansList.add(matrix[x1][j]);
            }
        }
        if(y < y1){
            for(int i = x1 - 1; i > x; i--){
                ansList.add(matrix[i][y]);
            }
        }
        dfs(matrix, x + 1, x1 - 1, y + 1, y1 - 1, ansList);
    }

}
