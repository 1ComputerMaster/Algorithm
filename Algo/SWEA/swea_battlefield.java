import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

class swea_battlefield
{
    static class Pair{
		public int x;
		public int y;
		public char z;
		public Pair(int x, int y,char z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	public static void main(String args[]) throws Exception
	{
		
		//System.setIn(new FileInputStream("res/input.txt"));

		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			Pair p = null;
			int H = sc.nextInt();
			int W = sc.nextInt();
			char[][] arr = new char[H][W];
			for(int i = 0;i<H;i++)
			{
				String str = sc.next();
				arr[i] = str.toCharArray();
				for(int j=0;j<W;j++) {
					if(arr[i][j]=='<' ||arr[i][j]=='>' || arr[i][j]=='^' ||arr[i][j]=='v') {
						p = new Pair(i,j,arr[i][j]);
					}
				}
				
			}
			int num = sc.nextInt();
			String str = sc.next();
			char[]move = new char[num];
			move=str.toCharArray();
			for(int i =0;i<move.length;i++) {
				if(move[i] == 'S') {
					int x = p.x; //x 값 받고
					int y = p.y; //y 값 받음
					if(p.z == '<') { //모양이 이러면
						while( (y-1 >= 0) && ((arr[x][y-1]=='*') || (arr[x][y-1]=='-') || (arr[x][y-1]=='.'))) { //y-1가 0 보다는 크거나 작아야 하고
							y-=1;
							if(arr[x][y]=='*') {
								arr[x][y]='.';
								break;
							}
						}
					}
					else if(p.z == '>') {
						while((y+1<W) && ((arr[x][y+1]=='*') || (arr[x][y+1]=='-') || (arr[x][y+1]=='.'))) {
							y+=1;
							if(arr[x][y]=='*') {
								arr[x][y]='.';
								break;
							} 
						}
					}
					else if(p.z == '^') {
						while((x-1 >= 0) && ((arr[x-1][y]=='*') || (arr[x-1][y]=='-') || (arr[x-1][y]=='.'))) {
							x-=1;
							if(arr[x][y]=='*') {
								arr[x][y]='.';
								break;
							}
						}
					}
					else if(p.z == 'v') {
						while((x+1 < H) && ((arr[x+1][y]=='*') || (arr[x+1][y]=='-') || (arr[x+1][y]=='.'))) {
							x+=1;
							if(arr[x][y]=='*') {
								arr[x][y]='.';
								break;
							}
						}
					}
				}
				else if(move[i] == 'U') {//Up
					int x = p.x;
					int y = p.y;
					p.z='^';
					arr[x][y]=p.z;
					if(x-1>=0 && arr[x-1][y]=='.') { //'U'
						arr[x][y] = '.';
						p.x -=1;
						x--;
						arr[x][y] = p.z;
					}
					
				}
				else if(move[i] == 'D') {//Down
					int x = p.x;
					int y = p.y;
					p.z='v';
					arr[x][y]=p.z;
					if(x+1<H && arr[x+1][y]=='.') {
						arr[x][y] = '.';
						p.x +=1;
						x++;
						arr[x][y] = p.z;
					}
				}
				else if(move[i] == 'R') {//Right
					int x = p.x;
					int y = p.y;
					p.z='>';
					arr[x][y]=p.z;
					if(y+1<W && arr[x][y+1]=='.') {
						arr[x][y] = '.';
						p.y +=1;
						y++;
						arr[x][y] = p.z;
					}
					
				}
				else if(move[i] == 'L') {//Left
					int x = p.x;
					int y = p.y;
					p.z='<';
					arr[x][y]=p.z;
					if(y-1>=0 && arr[x][y-1]=='.') {
						arr[x][y] = '.';
						p.y -=1;
						y--;
						arr[x][y] = p.z;
					}
				}
			}
			System.out.print("#"+test_case+" ");
			for(int i =0;i<H;i++) {
				for(int j = 0; j<W;j++)
				{
					System.out.print(arr[i][j]);
				}System.out.println();
			}
		}
	}
}