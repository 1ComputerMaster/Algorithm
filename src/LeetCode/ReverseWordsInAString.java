package LeetCode;

public class ReverseWordsInAString {
    public static void main(String[] args) {
        System.out.println(reverseWords("  hello world  "));
    }
    public static String reverseWords(String s) {
        String[] str = s.split(" ");
        StringBuilder ans = new StringBuilder();
        for(int i = str.length - 1; i >= 0 ; i--){
            if(str[i].isEmpty()){
                continue;
            }else{
                ans.append(str[i] + " ");
            }
        }
        s = ans.toString();
        return s.substring(0, s.length() - 1);
    }
}