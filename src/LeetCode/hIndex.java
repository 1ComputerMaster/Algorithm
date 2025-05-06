package LeetCode;

import java.util.Arrays;
import java.util.Collections;

public class hIndex {
    public static void main(String[] args) {
        int[] citations = {3,0,6,1,5};
        System.out.println(hIndex(citations));
    }
    public static int hIndex(int[] citations) {
        Integer[] citation = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(citation, Collections.reverseOrder());
        int cnt = 0;
        for(int i = 0; i < citation.length; i++){
            if(cnt + 1 <= citation[i]){
                cnt++;
            }else{
                return cnt;
            }
        }
        return cnt;
    }

}
