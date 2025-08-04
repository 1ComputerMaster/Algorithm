package LeetCode;

public class RotateImage {
    public static void main(String[] args) {
        RotateImage ri = new RotateImage();
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        ri.rotate(matrix);

        // Print the rotated matrix
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
    public void rotate(int[][] matrix) {
        int n = matrix.length;                                       // matrix is n x n :contentReference[oaicite:7]{index=7}
        // Loop over each “ring” layer
        for (int i = 0; i < n / 2; i++) {                             // i = 0 … n/2 - 1 :contentReference[oaicite:8]{index=8}
            for (int j = i; j < n - i - 1; j++) {                     // j = i … n-i-2 :contentReference[oaicite:9]{index=9}
                // Save top
                int tmp = matrix[i][j];
                // Left → Top
                matrix[i][j] = matrix[n - 1 - j][i];
                // Bottom → Left
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                // Right → Bottom
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                // Top (tmp) → Right
                matrix[j][n - 1 - i] = tmp;
            }
        }
    }
}
