package Disjoint_set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3289_서로소_집합 {
	static int []p;
	static int n;
	private static void make() {
		//모든 원소를 자신을 대표자로 만듦
		for (int i = 1; i <= n; i++) { //1부터 n포함까지
			p[i] = i;
		}
	}
	private static int find(int a) {
		if(a == p[a]) return a;//자신이 대표자
		return p[a] = find(p[a]);//자신이 속한 집합의 대표자를  자신의 부모로 : path compression
	}
	//두 원소를 하나의 집합으로 합치기(대표자를 이용해서 합침)
	private static boolean union(int a,int b) {
		a = find(a);
		b = find(b);
		if(a == b) return false;
		p[b] = a; // bRoot의 대표자를 aRoot로 바꾸어 버린다.
		return true;//새로 합쳐졌다는 의미에서 return true를 해준다.
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringTokenizer st;
		for(int t = 1;t<=T;t++)
		{
			st = new StringTokenizer(in.readLine()," ");
			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			p = new int[n+1];
			
			make();
			
			System.out.print("#"+t+" ");
			for(int i =0;i<m;i++) {
				st = new StringTokenizer(in.readLine()," ");
				int check = Integer.parseInt(st.nextToken());
				int node = Integer.parseInt(st.nextToken());
				int node2 = Integer.parseInt(st.nextToken());
				if(check == 0)
				{
					union(node,node2);
				}else{
					if(find(node) !=find(node2)) {
						System.out.print(0);
					}else {
						System.out.print(1);
					}
				}
			}
			System.out.println();
		}
	}

}
