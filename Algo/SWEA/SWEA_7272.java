import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_7272 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		String str;
		StringTokenizer tk;
		String first;
		String second;
		boolean diff;
		int sec_check[];
		int check[];
		for(int test_case = 1;test_case<=T;test_case++) {
			str = in.readLine();
			tk = new StringTokenizer(str," ");
			first = tk.nextToken();
			second = tk.nextToken();
			check = new int[first.length()];
			sec_check = new int[second.length()];
			diff = false;
			for(int i = 0;i<first.length();i++)
			{
				if(first.charAt(i) == 'A'|| first.charAt(i) =='D'|| first.charAt(i) == 'O' || first.charAt(i) == 'P'|| first.charAt(i) == 'Q'|| first.charAt(i) == 'R')
				{
					check[i] = 1;
				}
				else if(first.charAt(i) =='B') {
					check[i] = 2;
				}else {
					check[i] = 0;
				}
			}
			
			for(int i = 0;i<second.length();i++)
			{
				if(second.charAt(i) == 'A'|| second.charAt(i) =='D'|| second.charAt(i) == 'O' || second.charAt(i) == 'P'|| second.charAt(i) == 'Q'|| second.charAt(i) == 'R')
				{
					sec_check[i] = 1;
				}
				else if(second.charAt(i) =='B') {
					sec_check[i] = 2;
				}else {
					sec_check[i] = 0;
				}
			}
			if(first.length() != second.length()) {
				diff = true;
			}
			
			for(int i = 0;i<3;i++) {
				if(check[i]!=sec_check[i]) {
					diff = true;
				}
			}
			if(diff == false)
			{	
				System.out.println("#"+test_case +" SAME");
			}else {
				System.out.println("#"+test_case +" DIFF");
			}
		}
	}
}
