package BOJ.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1037_약수 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine()," ");
		int N = Integer.parseInt(tk.nextToken());
		tk = new StringTokenizer(in.readLine()," ");
		int min = Integer.MAX_VALUE;
		int max = 0;
		int size = tk.countTokens();
		int temp;
		for (int i = 0; i < size; i++) {
			temp = Integer.parseInt(tk.nextToken());
			min = Math.min(min, temp);
			max = Math.max(max, temp);
		}
		System.out.println(max * min);
	}

}
