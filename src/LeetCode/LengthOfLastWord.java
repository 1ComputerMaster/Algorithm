package LeetCode;

public class LengthOfLastWord {
    public static void main(String[] args) {

        String strTC1 = "Hello World";
        System.out.println(lengthOfLastWord(strTC1));

        String strTC2 = "   fly me   to   the moon  ";
        System.out.println(lengthOfLastWord(strTC2));

        String strTC3 = "luffy is still joyboy";
        System.out.println(lengthOfLastWord(strTC3));

    }
    public static int lengthOfLastWord(String s) {
        String[] word = s.split(" ");
        int ans = 0;
        for (int i = 0; i < word.length; i++) {
            if(word[i].isEmpty()){
                continue;
            }else {
                ans = (wordCount(word[i]));
            }
        }
        return ans;
    }

    private static int wordCount(String word) {
        int cnt = 0;
        for (int j = 0; j < word.length(); j++) {
            if (Character.isLetter(word.charAt(j))) {
                cnt++;
            }
        }
        return cnt;
    }
}
