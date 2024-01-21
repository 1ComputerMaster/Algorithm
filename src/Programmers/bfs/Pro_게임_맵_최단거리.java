package Programmers.bfs;;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Pro_게임_맵_최단거리 {
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
	static int[][] dist;
	public int solution(int[][] maps) {
        int answer = 0;
        dist = new int[maps.length][maps[0].length];
        for (int map[] : dist) {
			Arrays.fill(map, -1);
		}
        bfs(0,0,maps);
        answer = dist[maps.length - 1][maps[0].length - 1];
        return answer;
    }
	private void bfs(int x, int y,int[][] maps) {
		// TODO Auto-generated method stub
		Queue<Data> q = new LinkedList<>();
		q.add(new Data(x,y));
		dist[x][y] = 1;
		while(!q.isEmpty()) {
			Data cur = q.poll();
			for (int i = 0; i < dx.length; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if(nx < 0 || nx >= dist.length || ny < 0 || ny >= dist[0].length || dist[nx][ny] != -1 || maps[nx][ny] == 0) {
					continue;
				}
				dist[nx][ny] = dist[cur.x][cur.y] + 1;
				q.add(new Data(nx,ny));
			}
		}
	}
}