package BOJ.greedy;

import java.io.*;
public class BOJ_1343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String board = br.readLine();
        StringBuilder sb = new StringBuilder();

        int count = 0;
        for (char c : board.toCharArray()) {
            if (c == 'X') {
                count++;
            } else {
                if (count % 2 != 0) {
                    System.out.println(-1);
                    return;
                }
                sb.append("AAAA".repeat(count / 4));
                sb.append("BB".repeat((count % 4) / 2));
                sb.append('.');
                count = 0;
            }
        }
        if (count % 2 != 0) {
            System.out.println(-1);
            return;
        }
        sb.append("AAAA".repeat(count / 4));
        sb.append("BB".repeat((count % 4) / 2));
        System.out.println(sb.toString());
    }
}
