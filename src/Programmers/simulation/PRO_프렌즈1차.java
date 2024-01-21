package simulation;

public class PRO_프렌즈1차 {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
		char[][] crr = new char[m][n];
        
		for(int i = 0; i < m; i++) {
			crr[i] = board[i].toCharArray();
		}
        
		while(true) {
			int cnt = check(m, n, crr);
			if(cnt == 0) break;
			answer += cnt;
			dropBlock(m, n, crr);
		}
        return answer;
    }
    public void dropBlock(int m, int n, char[][] map) { //블록 내려오기
		for(int c = 0 ; c < n; c++) {//옆으로 부터 시작하면서
			for(int r = m - 1; r >= 0 ; r--) {// 아래 부터 탐색
				if(map[r][c] == '.') {//더 밑 부분이 '.'이고
					for(int nr = r - 1; nr >= 0; nr--) {
						if(map[nr][c] != '.') {// 거기서 부터 윗 부분에 알파벳이 있다면 그것은 내려와야 한다.
							map[r][c] = map[nr][c];// . 의 위치와 알파벳의 위치를 SWAP 한다.
							map[nr][c] = '.';// 알파벳 위치에는 .이 들어간다.
							break;
						}
					}
				}
			}
		}
	}

    public static int check(int n, int m, char[][] crr){
        boolean check[][] = new boolean[n][m];
        int cnt = 0;
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < m-1; j++){
                if(crr[i][j] != '.'){
                    if(crr[i][j] == crr[i+1][j] && crr[i][j] == crr[i][j+1] && crr[i][j] == crr[i+1][j+1]){
                        check[i][j] = true;
                        check[i][j+1] = true;
                        check[i+1][j+1] = true;
                        check[i+1][j] = true;
                    }else continue;
                }    
            }
        }
       for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(check[i][j] == true){ //사라진 블록 갯수 카운팅
                    crr[i][j] = '.';
                    cnt++;
                }
            }
        }
        return cnt;
    }
    
    
}