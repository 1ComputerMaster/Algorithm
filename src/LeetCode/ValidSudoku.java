package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '6', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(isValidSudoku(board)); // Output: true
    }
    public static boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            List<Character> row = new ArrayList<>();
            List<Character> col = new ArrayList();
            for(int j = 0; j < 9; j++){
                if(i % 3 == 0 && j % 3 == 0){
                    List<Character> validBox = new ArrayList();
                    for(int k = i; k < i + 3; k++){
                        for(int l = j; l < j + 3; l++){
                            if(validBox.contains(board[k][l]) && board[k][l] != '.'){
                                return false;
                            }
                            if(board[k][l] != '.')
                                validBox.add(board[k][l]);
                        }
                    }
                }
                if(row.contains(board[i][j]) && board[i][j] != '.'){
                    return false;
                }
                if(board[i][j] != '.')
                    row.add(board[i][j]);
                if(col.contains(board[j][i]) && board[j][i] != '.'){
                    return false;
                }
                if(board[j][i] != '.')
                    col.add(board[j][i]);
            }
        }
        return true;
    }

}
