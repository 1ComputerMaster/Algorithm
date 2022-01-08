package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2212_센서 {
	/*
	 N개의 센서 설치
	 -> 그러나 집중국은 K개만 설치 가능하다
	 -> 수신 가능 영역을 조절 할 수 있다.
	 -> 수신 가능 영역은 고속도로 상에서 연결된 구간으로 나타나게 된다.
	 -> N개의 센서는 적어도 하나의 집중국과 연결 되야함
	 -> 집중국 유지비 문제로 인해 각 집중국의 수신 가능 영역의 길이의 합을 최소화 하여야 한다.
	 
	 answer -> 결국 집중국 하나가 맞는 센서를 생각해서 푸는 문제다 즉, 집중국이 담당해서 보는 센서들
	 그 센서들은 모두 하나의 집중국으로 들어가니깐 거리가 센서간의 거리로 보면된다. 부분 집합처럼 생각하면된다.
	 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int K = Integer.parseInt(in.readLine());
		StringTokenizer tk = new StringTokenizer(in.readLine()," ");
		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(tk.nextToken());
		}
	
		Arrays.sort(arr);
		int sum = 0;
		
		Integer dist[] = new Integer[N - 1];
		for (int i = 0; i < N - 1; i++) {
			dist[i] = Math.abs(arr[i] - arr[i+1]);
		}
		Arrays.sort(dist,(o1,o2) -> o2 - o1);
		if(K > N) { // 집중국이 센서보다 많아져 버리면 이 경우가 된다.
			for(int i = 0; i < N-1; i++) { // ArrayBoundaryException
				dist[i] = 0;
			}
		}else {
			for(int i = 0; i < K-1; i++) {
				dist[i] = 0;
			}
		}
		for (int i = 0; i < dist.length; i++) {
			sum += dist[i];
		}
		System.out.println(sum);
	}
}
