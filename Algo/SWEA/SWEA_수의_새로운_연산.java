import java.util.Scanner;

public class SWEA_수의_새로운_연산 {

	static class Data{
		int x;
		int y;
		public Data(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case<=T;test_case++) {
			int q = sc.nextInt();
			int p = sc.nextInt();
			int temp = 0;
			for(int i = 1;i<150;i++) {
				temp+=i;//1,3,6,10
				if(q < temp) {
					int qline = temp - i;
					break;
				}
			}
			for(int i = 1;i<150;i++) {
				temp+=i;//1,3,6,10
				if(p < temp) {
					int pline = temp - i;
					break;
				}
			}
			
		}
		
		
	}
	
	
}
