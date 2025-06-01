package LeetCode;

public class SearchMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1},{3}};
        int target = 4;
        System.out.println(searchMatrix(matrix, target));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix[0].length;
        int m = matrix.length;
        int matrixIdx = 0;
        if(m > 1){
            matrixIdx = findArray(n,m,matrix, target);
        }
        int left = 0;
        int right = n - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(matrix[matrixIdx][mid] == target){
                return true;
            }
            if(matrix[matrixIdx][mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return false;
    }
    private static int findArray(int n, int m, int[][] matrix, int target){
        int left = 0;
        int right = m - 1;
        while(left <= right){
            int mid = (left + right) / 2;

            if(matrix[mid][0] >= target && matrix[mid][n - 1] <= target){
                return mid;
            }
            if(matrix[mid][n - 1] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        if(left >= m){
            return left - 1;
        }
        return left;

    }
}
