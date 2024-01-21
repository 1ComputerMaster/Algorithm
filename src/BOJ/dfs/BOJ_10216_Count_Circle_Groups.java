/*package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_10216_Count_Circle_Groups {
	static boolean visited[][],check[][];
	static class Data{
		int x;
		int y;
		public Data(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static Data first;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine()," ");
		int T = Integer.parseInt(tk.nextToken());
		
		for (int t = 0; t < T; t++) {
			visited = new boolean[5001][5001];
			check = new boolean[5001][5001];
			tk = new StringTokenizer(in.readLine()," ");
			int n = Integer.parseInt(tk.nextToken());
			int x = 0;
			int y = 0;
			int weight = 0;
			for (int i = 0; i < n; i++) {
				tk = new StringTokenizer(in.readLine()," ");
				x = Integer.parseInt(tk.nextToken());
				y = Integer.parseInt(tk.nextToken());
				weight = Integer.parseInt(tk.nextToken());
				first = new Data(x,y);
				dfs(x,y,weight);
			}
			int ans = 0;
			for (int i = 0; i < 5001; i++) {
				for (int j = 0; j < 5001; j++) {
					if(visited[i][j] == true && check[i][j] == false) {
						find(i,j);
						ans++;
					}
				}
			}
			System.out.println(ans);
		}
		
		

	}

	private static void find(int x, int y) {
		Queue<Data> q = new LinkedList<>();
		q.add(new Data(x,y));
		check[x][y] = true;
		while(!q.isEmpty()) {
			Data cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				if(nx < 0 || nx >= 5000 || ny < 0 || ny >= 5000) continue;
				if(check[nx][ny] == true) continue;
				if(visited[nx][ny] == true) {
					q.add(new Data(nx,ny));
					check[nx][ny] = true;
				}else {
					continue;
				}
			}
		}
		
	}

	private static void dfs(int x, int y, int weight) {
		visited[x][y] = true;
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if(nx < 0 || nx >= 5000 || ny < 0 || ny >= 5000) continue;
			if(nx < (first.x - weight) || nx >= (first.x + weight) || ny < (first.y - weight) || ny >= (first.y + weight))
				continue;
			if(visited[nx][ny] == true) continue;
			visited[nx][ny] = true;
			dfs(nx,ny,weight);
		}
	}

}
*/
package BOJ.dfs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
거리 간의 차이로 알아낸다. 갈 수 있는지 없는 지를
 */
public class BOJ_10216_Count_Circle_Groups {

    static boolean[] visit;
    static List<Dot> dot;
    static int cnt;

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int T = Integer.parseInt(st.nextToken());

        int flag = 0;
        dot = new ArrayList<>();

        while(flag < T) {

            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());

            dot = new ArrayList<>();

            for(int i=0; i<k; ++i) {

                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());

                dot.add(new Dot(x, y, a));
            }

            visit = new boolean[k];
            cnt = 0;
            
            for(int j=0; j<dot.size(); ++j) {

                if(!visit[j]) {
                    dfs(dot.get(j), j);
                    cnt++;
                }
            }

            System.out.println(cnt);

            flag++;
        }

    }

    static void dfs(Dot d, int index) {

        if(visit[index]) return;

        visit[index] = true;

        for(int i=0; i<dot.size(); ++i) {

            Dot nd = dot.get(i);

            int dis = (d.x - nd.x) * (d.x - nd.x) + (d.y - nd.y) * (d.y - nd.y); //거리 차이가

            if(dis <= (d.a + nd.a) * (d.a + nd.a)) { // 서로간의 가는 차이 보다 작으면
                dfs(nd, i); //같은 거리니깐 다시 넣어서 탐색을 막고
            }

        }

    }


     static class Dot {

        int x,y,a;

        Dot(int x, int y, int a) {

            this.x = x;
            this.y = y;
            this.a = a;
        }
    }
}


