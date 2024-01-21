# 1. CCW

- 기하학의 기초인 CCW를 활용하는 문제 신발끈 공식을 이용한다.

[CCW 정리](https://degurii.tistory.com/47)



![image](https://user-images.githubusercontent.com/87481266/149943190-0ec9252b-e79d-4f48-bbea-9923d5d51c9f.png)

먼저, 빨간색 빗금을 곱셈해서 더해줌
x1y2 + x2y3 + x3y1 

![image](https://user-images.githubusercontent.com/87481266/149943234-f6aa4ec7-261f-49fb-ac77-8eeb5330dd4d.png)

파란색 빗금을 곱셈하서 더해줌

x2y1 + x3y2 + x1y3

그 후 빨간색 빗금으로 구한 것과 파란색 빗금으로 구한 것을 서로 빼면 된다.

x1y2 + x2y3 + x3y1 - (x2y1 + x3y2 + x1y3) 


```

package simulation;

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


```