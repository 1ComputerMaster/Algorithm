package simulation;
import java.util.Stack;

class Pro_크레인_인형뽑기_게임 {
	public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < moves.length; i++) {
            for (int k = 0; k < board.length; k++) {
                if(board[k][moves[i]-1]!=0) {
                    int temp = board[k][moves[i]-1];
                    board[k][moves[i]-1] = 0;
                    if(!s.empty()) {
                        if(s.peek() == temp) {
                            s.pop(); //빼고
                            answer+=2;
                        }else {
                            s.push(temp); // 다르면 그냥 넣음
                        }
                    }else{
                        s.push(temp); // 비어있어도 넣음
                    }
                    break;
                }
            }
        }
        return answer;
    }
}