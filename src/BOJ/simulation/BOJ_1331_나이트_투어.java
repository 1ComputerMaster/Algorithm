package BOJ.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1331_나이트_투어 {
	static int check[];
	static int curx,cury;
	static int dx[] = { -2,-1,1,2,2,1,-1,-2 };
	static int dy[] = { 1,2,2,1,-1,-2,-2,-1 };
	private static boolean isValid;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str;
		check = new int[]{0,1,2,3,4,5};
		int arr[][] = new int[6][6];
		boolean visited[][] = new boolean[6][6];
		str = in.readLine();
		
		int fx = check[(str.charAt(0)-'A')];
		int fy = check[(str.charAt(1)-'1')];
		
		visited[fx][fy] = true;
		
		int x = fx;
		int y = fy;
		
		for (int i = 1; i < 36; i++) {
			str = in.readLine();
			
			isValid = false;
			
			curx = check[(str.charAt(0)-'A')];
			cury = check[(str.charAt(1)-'1')];
			
			for (int j = 0; j < 8; j++) {
				
				int nx = curx + dx[j];
				int ny = cury + dy[j];
				
				if (nx < 0 || nx >= 6 || ny < 0 || ny >= 6) 
					continue;
				
				if(nx == fx && ny == fy && visited[curx][cury] == false) {
					isValid = true;
					visited[curx][cury] = true;
					break;
				}
				
			}
			if(isValid == false) {
				System.out.println("Invalid");
				return;
			}else {
				fx = curx;
				fy = cury; //다음으로 넘어간다
			}
		}
		
		isValid = false;
		
		for (int i = 0; i < 8; i++) {
			if(x == fx + dx[i] && y == fy + dy[i]) {
				isValid = true;
				break;
			}
		}
		
		if(isValid == false) {
			System.out.println("Invalid");
			return;
		}else {
			System.out.println("Valid");
		}
		
	}

}
