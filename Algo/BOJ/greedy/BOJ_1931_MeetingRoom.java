package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1931_MeetingRoom {
	static class Data implements Comparable<Data>{
		int start;
		int end;
		
		public Data() {
		}
		public Data(int start, int end) {
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Data o) {
			// TODO Auto-generated method stub
			int value = this.end - o.end;
			if(value != 0)return value;
			return this.start - o.start;
		}
		@Override
		public String toString() {
			return "Data [start=" + start + ", end=" + end + "]";
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Data data[] = new Data[N];
		ArrayList<Data> list = new ArrayList<Data>();
		for(int i = 0;i<N;i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			data[i] = new Data(start,end);
		}
		Arrays.sort(data);
		list.add(data[0]);
		for(int i = 1; i<N;i++) {
			if(list.get(list.size()-1).end <= data[i].start) {
				list.add(data[i]);
			}else {
				continue;
			}
		}
		System.out.println(list.size());
		
	}
}
