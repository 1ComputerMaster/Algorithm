import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
 * 냉장고 문제
 *  회의실 배정이랑 비슷하다 -> 간단하게 int형 변수로 그때 그 위치의 최고 온도 값만 받아서
 *  비교하면 된다.
 */
public class Jungol_1828_냉장고 {
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
		ArrayList<Data> list = new ArrayList<Data>();
		for(int i = 0; i<N;i++) {
			list.add(new Data(sc.nextInt(),sc.nextInt()));
		}
		Collections.sort(list); //최고 온도 기준 오름차순 정렬
		int cnt = 1;
		int temp = list.get(0).end;
		for(int i = 1;i<list.size();i++) {
			if(temp < list.get(i).start) { //빠져나갔다
				cnt++;
				temp = list.get(i).end; //여기서 부터 다시 시작
			}
		}
		System.out.println(cnt);
	}
}
