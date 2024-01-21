package BOJ.dfs;

import java.util.*;

public class PRO_연속된_부분_수열의_합 {
    public static void main(String[] args) {
        int [] arr = solution(new int[]{1,1,1,2,3,4,5},5);

        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i] + " ");
        }
    }

    public static int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int left = 0;
        int right = 0;
        int ans = sequence[0];
        List<Sequence> list = new ArrayList<Sequence>();
        while(true){
            if (ans == k){
                list.add(new Sequence(left, right));
            }
            if(left == sequence.length && right == sequence.length){
                break;
            }
            
            if(ans <= k && right < sequence.length){
                right++;
                if(right < sequence.length){
                    ans += sequence[right];
                }
            }else{
                if(left < sequence.length)
                {
                    ans -= sequence[left];
                } 
                left++;
            }
        }
        Collections.sort(list);
        answer[0] = list.get(0).left;
        answer[1] = list.get(0).right;
        return answer;
    }
    public static class Sequence implements Comparable<Sequence>{
        int left;
        int right;
        int size;
        public Sequence(int left, int right) {
            this.left = left;
            this.right = right;
            this.size = right - left;
        }
        @Override
        public int compareTo(Sequence o) {
            if(this.size == o.size){
                return Integer.compare(this.left, o.left);
            }
            return this.size - o.size;
        }
        
    }
}
