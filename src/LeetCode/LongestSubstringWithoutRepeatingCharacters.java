package LeetCode;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters lswrc = new LongestSubstringWithoutRepeatingCharacters();
        String s = "pepew";
        System.out.println(lswrc.lengthOfLongestSubstring(s)); // Should return 3
    }
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] index = new int[26]; // ASCII character set
        int maxLength = 0;
        int start = 0;

        for (int end = 0; end < n; end++) {
            int currentChar = s.charAt(end) - 'a';
            if (index[currentChar] > start) {
                start = index[currentChar];
            }
            index[currentChar] = end + 1; // Update the last seen index of the character
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}
