package BOJ.String;

import java.io.*;

public class BOJ_16916 {

    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String S = in.readLine();
        String P = in.readLine();

        if (kmpSearch(S, P)) {
            bw.write("1");
        } else {
            bw.write("0");
        }
        bw.flush();
        bw.close();
    }

    public static boolean kmpSearch(String text, String pattern) {
        int[] lps = computeLPSArray(pattern);
        int i = 0;  // index for text
        int j = 0;  // index for pattern

        while (i < text.length()) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }
            if (j == pattern.length()) {
                return true;  // found pattern at index i - j
            } else if (i < text.length() && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return false;
    }

    public static int[] computeLPSArray(String pattern) {
        int length = 0;  // length of the previous longest prefix suffix
        int i = 1;
        int[] lps = new int[pattern.length()];
        lps[0] = 0;  // lps[0] is always 0

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
