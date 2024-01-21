package SWEA.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_10912_외로운_문자 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		char[] crr;
		
		PriorityQueue<Character> pq;
		String ans = "";
		for(int t = 1;t<=T;t++) {
			ans = "";
			String str = in.readLine();
			pq = new PriorityQueue<>();
			crr=new char[str.length()];
			for(int i = 0;i<str.length();i++)
			{
				pq.add(str.charAt(i));
			}
			while(!pq.isEmpty()) {
				char temp = pq.poll();
				if(pq.contains(temp)) {
					pq.poll();
				}else {
					ans+=temp;
				}
			}
			if(ans.length() == 0) {
				System.out.println("#"+t+" "+"Good");
			}else {
				System.out.println("#"+t+" "+ans);
			}
		}
	}

}
