package SWEA.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Vector;

/*
 * 처음에는 ArrayList<int[]> 형태로 나오는 배열을 받아서 넣으려고 했으나
 * 배열은 계속 같은 곳을 가르키는 그 배열만 가져오게 되어서 사실상 ArrayList.get(0)번째의 값만 나오게 되었다
 * -> 조합에서 배열로 바로 값을 받아서 처리하지 말고 visit 처리하여서 그 곳을 다녀갔으면 체킹하는 식 
 * visited 초기화를 계속 하는 것 보다 백트래킹하여서 갔던데 다시 초기화 시켜줌 그러면 들어간거는 이미 다 처리되고
 * 다시 재귀 풀리면서 하나씩 다시 돈다.
 */

public class SWEA_4012_요리사 {
	static int N;
	//static int[] numbers;
	//static int[] ant_nums;
	//static ArrayList<int[]> A; //A 음식
	//static ArrayList<int[]> B; //B 음식
	static int arr[][];
	static int ans;
	private static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int test_case = 1; test_case <=T;test_case++)
		{
			ans = Integer.MAX_VALUE;//답 제시용
			N =Integer.parseInt(in.readLine());//N 입력 받고
			//numbers = new int[N/2]; // 반개만 입력
			//ant_nums = new int[N/2]; // 반개만 입력
			visited = new boolean[N];
			String str; // str은 임시용
			arr = new int[N][N];//전체 배열
			StringTokenizer tk;
			//A = new ArrayList<>(); //다시 초기화
			//B = new ArrayList<>();
			
			for(int i = 0;i<N;i++) {
				str = in.readLine();
				tk = new StringTokenizer(str," ");
				for(int j = 0;j<N;j++) {
					arr[i][j]=Integer.parseInt(tk.nextToken());
				}
			}
			comb(0,0);
			
			System.out.println("#"+test_case+" "+ans);
		}
	}

	private static int getSnergy() {
		int A = 0;
		int B = 0;
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<N;j++) {
				if(i!=j)
				{
					/*System.out.println("[ "+A[i]+" "+A[j]+" ]");
					System.out.println("[ "+ B[i]+" "+B[j]+" ]");*/
					if(visited[i] && visited[j])
					{
						A += arr[i][j]; // 다 돌아가면서 넣고 1,3 3,5 5,3 ... 조합으로 들어간게 돌면서 순열 처럼 계속  뒤 바뀜
					}
					else if(visited[i] == false && visited[j]==false){
						B += arr[i][j]; // 다 돌아가면서 넣음
					}
				}
			}
		}
		return Math.abs(A-B);
	}

	
	private static void comb(int n,int start) {
		if(N/2 == n) {
			ans=Math.min(getSnergy(),ans);
			return;
		}else {
			for(int i = start;i<N;i++) {
				visited[i] = true;
				comb(n+1,i+1);
				visited[i] = false; //백트래킹
			}
		}
	}
}
	/*if(N/2 == n) {
	A.add(numbers);
	System.out.println(Arrays.toString(numbers));
	int cnt = 0;
	boolean check = true;
	for(int i = 0;i<N;i++) {
		for(int j = 0;j<N/2;j++) {
			if(numbers[j] == i) {
				check = false;
				continue;
			}
		}
		if(check == true) {
			ant_nums[cnt++] = i;
		}
		check = true;
	}			
	B.add(ant_nums);
	numbers = new int[N/2]; //새로운 배열으로 초기화
	ant_nums = new int[N/2]; //그래야 ArrayList에서 다른 배열로 인식하고 넣음
	
	return;
}
else {
	for(int i = start; i<N;i++) {
		visited[n] = i; //start 부터 시작 
		comb(n+1,i+1);
	}
}
}*/