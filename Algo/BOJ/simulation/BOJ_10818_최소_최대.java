package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10818_최소_최대 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer tk = new StringTokenizer(in.readLine()," ");
		Integer arr[] = new Integer[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(tk.nextToken());
		}
		Arrays.sort(arr);
		System.out.print(arr[0]+ " ");
		Arrays.sort(arr,(o1,o2) -> o2.compareTo(o1));
		System.out.print(arr[0]);
	}
}
