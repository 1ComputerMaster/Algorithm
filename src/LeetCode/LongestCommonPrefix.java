package LeetCode;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }
    public static String longestCommonPrefix(String[] strs) {
        String sameStr = strs[0];
        StringBuilder nowStr;
        for (String str : strs) {
            nowStr = new StringBuilder();
            int n = Math.min(sameStr.length(), str.length());
            for (int j = 0; j < n; j++) {
                if (sameStr.charAt(j) == str.charAt(j)) {
                    nowStr.append(sameStr.charAt(j) + "");
                } else {
                    break;
                }
            }
            sameStr = nowStr.toString();
        }
        return sameStr;
    }

}
