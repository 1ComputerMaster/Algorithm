package BOJ.Divide;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_4779 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        while ((input = br.readLine()) != null && !input.isBlank()) {
            int n = Integer.parseInt(input);
            int length = (int) Math.pow(3, n);
            generateCantorSet(0, length, bw);
            bw.write("\n"); // 줄바꿈
        }
        bw.flush();
        bw.close();
    }

    private static void generateCantorSet(int start, int length, BufferedWriter bw) throws Exception {
        if (length == 1) {
            bw.write("-");
            return;
        }
        int third = length / 3;
        generateCantorSet(start, third, bw);
        for (int i = 0; i < third; i++) {
            bw.write(" ");
        }
        generateCantorSet(start + 2 * third, third, bw);
    }
}
