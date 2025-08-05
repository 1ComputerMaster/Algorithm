package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        SetMatrixZeroes smz = new SetMatrixZeroes();
        int[][] matrix = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };
        smz.setZeroes(matrix);
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<int[]> whereList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 0){
                    whereList.add(new int[]{i, j});
                }
            }
        }
        for(int[] where : whereList){
            finder(where[0], where[1], matrix);
        }
    }
    private void finder(int x, int y, int[][] matrix){
        int n = matrix.length - 1;
        int m = matrix[0].length - 1;

        for(int i = 0; i <= n; i++){
            matrix[i][y] = 0;
        }

        for(int j = 0; j <= m; j++){
            matrix[x][j] = 0;
        }
    }
}
