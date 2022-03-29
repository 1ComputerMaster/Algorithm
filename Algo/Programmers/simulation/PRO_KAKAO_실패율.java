package simulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PRO_KAKAO_실패율 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int stages[] = {4,4,4,4,4};
		int N = 4;
		System.out.print(Arrays.toString(solution(N, stages)));
	}
	static class Data implements Comparable<Data>{
		int x;
		double weight;
		public Data(int x, double weight) {
			this.x = x;
			this.weight = weight;
		}
		@Override
		public int compareTo(Data o) {
			return Double.compare(o.weight, this.weight);
		}
	}
	public static int[] solution(int N, int[] stages) {
		int answer[] = new int[N];
		ArrayList<Data> list = new ArrayList();
		for(int i = 1; i <= N; i++) {
			double tmp = 0;
			double cnt = stages.length;
			for(int j = 0; j < stages.length; j++) {
				if(i > stages[j]) {
					cnt--;
				}
				if(i == stages[j]) {
					tmp++;
				}
			}
			if(cnt == 0){
                list.add(new Data(i,-1)); // 0로 나눌수 없다.
            }else {
            	list.add(new Data(i,(tmp/cnt)));
            }
		}
		Collections.sort(list);
		
		for(int i = 0; i < N; i++) {
			answer[i] = list.get(i).x;
		}
		return answer;
	}
}
