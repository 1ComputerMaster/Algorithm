package BOJ.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11758_CCW {
	static class Data{
		int x;
		int y;
		public Data(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		//선분의 방향을 구하는 문제
		/*반시계 방향이면 1 시계 방향이면 -1 일직선이면 0
		 * 
		 * */
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine()," ");
		Data p1 = new Data(Integer.parseInt(tk.nextToken()),Integer.parseInt(tk.nextToken()));
		tk = new StringTokenizer(in.readLine()," ");
		Data p2 = new Data(Integer.parseInt(tk.nextToken()),Integer.parseInt(tk.nextToken()));
		tk = new StringTokenizer(in.readLine()," ");
		Data p3 = new Data(Integer.parseInt(tk.nextToken()),Integer.parseInt(tk.nextToken()));
		System.out.println(ccw(p1,p2,p3));
		
	}
	private static int ccw(Data p1, Data p2 ,Data p3) {
		int ans = p1.x*p2.y + p2.x*p3.y + p3.x*p1.y - (p2.x*p1.y + p3.x*p2.y + p1.x*p3.y);
		if(ans < 0) {
			ans = -1;
		}else if(ans == 0) {
			ans = 0;
		}else {
			ans = 1;
		}
		return ans;
	}

}
