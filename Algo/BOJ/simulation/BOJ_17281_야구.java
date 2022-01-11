package simulation;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17281_야구 {
	/**
	 * 백준 17281 야구 (https://www.acmicpc.net/problem/17281)
	 */
	private static int n;
	private static int[][] map;
	private static boolean[] visit;
	
	private static int[] player;
	
	private static int result = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(reader.readLine());
		
		map = new int[n+1][10];
		
		StringTokenizer st;
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j=1; j<=9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visit = new boolean[10];
		player = new int[10];
		
		visit[4] = true; //이미 4번 타자는 정해진꼴
		player[4] = 1; //어짜피 1번이 4번 타자로 들어가니깐
		
		dfs(2);
		
		System.out.println(result);
		
	}

	private static void dfs(int count) {

		if (count == 10) {
			
			//순서 조합 끝
			
			//경기 시작
			play();
			
		} else {
			
			for (int i=1; i<=9; i++) {
				if (!visit[i]) { //등록 안 된 곳만 다시 재 배정한다.
					visit[i] = true;
					player[i] = count; //순서를 count로 배치
					dfs(count+1);
					visit[i] = false;
				}
			}
		}
		
	}//dfs

	private static void play() { //정해진 player 순서를 기반으로 시작한다.
		
		int score = 0;
		int startPlayer = 1;
		boolean[] base;
		
		for (int i=1; i<=n; i++) {
			int outCnt = 0;
			base = new boolean[4];
			
			finish : while(true) {
				for (int j=startPlayer; j<=9; j++) { //1번 플레이어 부터 시작한다.
					int hitter = map[i][player[j]]; //1번 플레이어의 배치는 count로 순열로 정해진 순서가 들어간다.
					//그때의 hitter의 점수가 나오고
					switch (hitter) {
					case 0: //아웃
						outCnt++; //아웃 카운터 한 번 올라간다.
						break;
					case 1: //1루타
						for (int k=3; k>=1; k--) {
							if (base[k]) {
								if (k==3) {
									score++;
									base[k] = false;
									continue;
								}

								base[k] = false;
								base[k+1] = true;
							}
							
						}
						base[1] = true;
						break;
					case 2: //2루타
						for (int k=3; k>=1; k--) {
							if (base[k]) {
								if (k==3 || k==2) {
									score++;
									base[k] = false;
									continue;
								}
								base[k] = false;
								base[k+2] = true;
							}
						}
						base[2] = true;
						break;
					case 3: //3루타
						for (int k=1; k<=3; k++) {
							if (base[k]) {
								score++;
								base[k] = false;
							}
						}
						base[3] = true;
						break;
					case 4: //홈런
						for (int k=1; k<=3; k++) {
							if (base[k]) {
								score++;
								base[k] = false;
							}
						}
						score++;
						break;
					}

					if (outCnt == 3) { //아웃 카운터가 3이면
						startPlayer = j + 1; //startPlayer의 순서가 j + 1로 부터 저장하여야 다음 이닝때 그 순서 부터 시작한다.
						if (startPlayer == 10) { //10번이면 다시 1번으로
							startPlayer = 1;
						}
						break finish;
					}
				}
				//아웃 안 되고 startPlayer가 9까지 다 와버려서 끝나면 다시 처음 부터 그 player 배열에서 시작한다
				//그대로 가져다 씀
				startPlayer = 1;
			}
		}
		
		result = Math.max(result, score);
		
	}//play
}
