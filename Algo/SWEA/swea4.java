import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t=1; t<=1; t++){
            br.readLine();
            int[][] map = new int[100][100];
            index start = new index(0,0);

            for(int i=0; i<100; i++){
                String[] input = br.readLine().split(" ");
                for(int j=0; j<100; j++){
                    map[i][j] = Integer.parseInt(input[j]);
                    if(map[i][j] == 2) {
                        start = new index(i, j);
                    }
                }
            }

            while(start.x!=0) {
                if(start.y-1 >= 0 && map[start.x][start.y-1]==1) {
                    while(start.y-1>=0 && map[start.x][start.y-1]==1) {
                        start.y--;
                    }
                }
                else if(start.y+1<100 && map[start.x][start.y+1]==1) {
                    while(start.y+1<100 && map[start.x][start.y+1]==1) {
                        start.y++;
                    }
                }
                start.x--;
            }

            System.out.println("#" + t + " " + start.y);
        }
    }
    public static class index{
        int x;
        int y;

        public index(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}