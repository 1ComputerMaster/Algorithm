package LeetCode;

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean check = false;
        for(int[] map : matrix){
            check = binarySearch(map, target);
            if(check){
                return true;
            }
        }
        return false;
    }
    private boolean binarySearch(int[] map, int target){
        int left = 0;
        int right = map.length - 1;

        while(left <= right){
            int mid = (left + right) / 2;
            if(map[mid] == target){
                return true;
            }
            else{
                if(map[mid] < target){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
