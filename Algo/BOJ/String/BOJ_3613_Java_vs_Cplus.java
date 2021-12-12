package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3613_Java_vs_Cplus {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		boolean c_check = false; // c일때 체크함
		boolean check = false; //연속으로 _ 나오면
		StringTokenizer tk;
		
		for(int i = 0;i<str.length();i++) {
			for (int j = 0; j < 26; j++) {
				if(i == 0) {
					for (int j2 = 0; j2 < str.indexOf("_"); j2++) {
						if(str.charAt(j2) == 'A' + j) {
							System.out.println("Error!"); //첫 문자가 대문자
							return;
						}
					}
					if(str.charAt(i) == 'A' + j) {
						System.out.println("Error!"); //첫 문자가 대문자
						return;
					}
					if(str.charAt(i) == '_') {
						System.out.println("Error!");
						return;
					}
				}else {
					if(str.charAt(i) == 'A' + j && c_check) {
						System.out.println("Error!"); //첫 문자가 대문자
						return;
					}
					if(str.charAt(i) == '_') {
						if(check) {
							System.out.println("Error!"); //연속한 _ 등장
							return;
						}
						c_check = true;
						check = true;
						if(i == str.length() - 1) {
							System.out.println("Error!"); //첫 문자가 대문자
							return;
						}
						break;
					}
					check = false;
				}
			}
		}
		
		if(c_check) {
			tk = new StringTokenizer(str,"_");
			int size = tk.countTokens();
			for (int i = 0; i < size; i++) {
				String java = tk.nextToken();
				if(i == 0) {
					System.out.print(java);
					continue;
				}
				char []c = java.toCharArray();
				c[0] = Character.toUpperCase(c[0]);
				System.out.print(c);
			}
		}else {
			char[] c_arr = str.toCharArray();
	        StringBuilder sb = new StringBuilder();
	        for(int i = 0; i < c_arr.length; i++) {
	            char c = c_arr[i];
	            if(c >= 65 && c <= 90) {
	                sb.append('_');
	                sb.append((char)(c + 32));
	            } else {
	                sb.append(c);
	            }
	        }
	        System.out.println(sb.toString());
	        return;
		}
	}

}
