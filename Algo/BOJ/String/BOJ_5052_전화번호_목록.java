package String;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_5052_전화번호_목록 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine()); //2
		for (int i = 0; i < t; i++) { //2
			int N = Integer.parseInt(in.readLine()); //3
			boolean check = false;
			ArrayList<String> list = new ArrayList<String>();
			for (int j = 0; j < N; j++) {
				String str = in.readLine();
				list.add(str);
			}
			Collections.sort(list);
			for (int j = 0; j < N - 1; j++) {
				if(list.get(j+1).startsWith(list.get(j))) {
					check = true;
					System.out.println("NO");
					break;
				}
			}
			if(!check)
			{
				System.out.println("YES");
			}
		}
	}
}
