package LeetCode;

public class Reverse_String {
    public static void main(String[] args) {
        Reverse_String r = new Reverse_String();
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        r.reverseString(s);
        System.out.println(s); // Should print "olleh"
    }
    public void reverseString(char[] s) {
        for(int i = s.length - 1; i >= (s.length / 2); i--){
            char tmp = s[(s.length - 1) - i];
            s[(s.length - 1) - i] = s[i];
            s[i] = tmp;
        }
    }
}
