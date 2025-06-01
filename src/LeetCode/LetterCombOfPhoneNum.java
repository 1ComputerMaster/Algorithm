package LeetCode;
import java.util.*;
public class LetterCombOfPhoneNum {
    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }
    static char[][] crr;
    static List<Integer> num;
    static int cnt = 0;
    static List<String> ansList;
    public static List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return List.of();
        }
        num = new ArrayList<>();
        for(int i = 0; i < digits.length(); i++){
            num.add(Integer.parseInt(String.valueOf(digits.charAt(i))));
        }
        cnt = num.size();
        crr = new char[10][4];
        init(crr);
        ansList = new ArrayList<>();
        comb(0, new StringBuilder());
        return ansList;
    }
    private static void init(char[][] crr){
        crr[2] = new char[]{'a', 'b', 'c'};
        crr[3] = new char[]{'d','e','f'};
        crr[4] = new char[]{'g','h','i'};
        crr[5] = new char[]{'j','k','l'};
        crr[6] = new char[]{'m','n','o'};
        crr[7] = new char[]{'p','q','r','s'};
        crr[8] = new char[]{'t','u','v'};
        crr[9] = new char[]{'w','x','y','z'};
    }
    private static void comb(int count, StringBuilder sb){
        if(cnt == count){
            ansList.add(sb.toString());
            return;
        }
        int where = num.get(count);
        for(int i = 0; i < crr[where].length; i++){
            comb(count + 1, sb.append(crr[where][i]));
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
