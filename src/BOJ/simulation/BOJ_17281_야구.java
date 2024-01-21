package BOJ.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_17281_야구{
	static int N,arr[][];
	static boolean visited[];
	static int[] runner;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		
		arr = new int[N+1][10];
		
		StringTokenizer tk;
		for (int i=1; i<=N; i++) {
			tk = new StringTokenizer(in.readLine());
			for (int j=1; j<=9; j++) {
				arr[i][j] = Integer.parseInt(tk.nextToken());
			}
		}
		
		visited = new boolean[10];
		runner = new int[10];
		
		visited[4] = true; //이미 4번 타자는 정해진꼴
		runner[4] = 1; //어짜피 1번이 4번 타자로 들어가니깐
		perm(2);
		System.out.println(ans);
	}
	static boolean base[];
	private static int ans = 0;
	private static void perm(int count) {
		if(count == 10) {
			play();
		}
		else {
			for (int i = 1; i < 10; i++) {
				if(visited[i]) {
					continue;
				}
				visited[i] = true;
				runner[i] = count;
				perm(count+1);
				visited[i] = false;
			}
		}
	}
	
	private static void play() {
		int point = 0;
		int startPlayer = 1;
		for (int i = 1; i <= N; i++) {
			int outCnt = 0;
			base = new boolean[4];
			loop : while(true) {
				for (int j = startPlayer; j < 10; j++) { //시작 플레이어 부터 시작함
					
					int hitter = arr[i][runner[j]]; //해당 이닝의 순번의 선수의 포인트가 들어옴
					
					if(hitter == 0) {
						outCnt++;
					}else if(hitter == 1) { //1점
						for (int k=3; k>=1; k--) {
							if (base[k]) {
								if (k==3) { //3 루타 지점에 있던 주자 출루
									point++; //점수 나고
									base[k] = false; // 그 자리 이제 사람 없으니깐 false
									continue;
								}
								base[k] = false; //만약에 2루타나 1루타에 사람이 있으면 그 사람ㅁ들은 다시 3루 2루 출루하므로
								base[k+1] = true;
							}
							
						}
						base[1] = true; //1루타는 쳤으므로
					}else if(hitter == 2) //2 루타
					{
						for (int k=3; k>=1; k--) {
							if (base[k]) {
								if (k==3 || k==2) {
									point++;
									base[k] = false;
									continue;
								}
								base[k] = false;
								base[k+2] = true;
							}
						}
						base[2] = true;
					}else if(hitter == 3) { // 3 루타
						for (int k=1; k<=3; k++) {
							if (base[k]) {
								point++;
								base[k] = false;
							}
						}
						base[3] = true;
					}else if (hitter == 4){
						for (int k=1; k<=3; k++) {
							if (base[k]) {
								point++;
								base[k] = false;
							}
						}
						point++;
					}
					if(outCnt == 3) {
						startPlayer = j+1;
						if(startPlayer == 10) {
							startPlayer = 1; //원형 큐 처럼 도는 형식
						}
						break loop;
					}
				}
				//아웃 안 되고 startPlayer가 9까지 다 와버려서 끝나면 다시 처음 부터 그 player 배열에서 시작한다
				//그대로 가져다 씀
				startPlayer = 1;
			}
		}
		ans = Math.max(ans, point);
	}
}