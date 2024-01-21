package simulation;

import java.util.ArrayList;

public class PRO_소수_만들기 {
	static int N;
	static int number[];
	static int answer;
	public int solution(int[] nums) {
		list = new ArrayList<>();
        answer = -1;
        N = nums.length;
        number = new int[N];
        comb(0,0,nums);
        answer = list.size();
        return answer;
    }
	public static boolean is_prime(int number) {
		if(number < 2) {
			return false;
		}
		if(number == 2) {
			return true;
		}
		for(int i = 2; i < number; i++) {
			if(number % i == 0) {
				return false;
			}
		}
		return true;
	}
	static ArrayList<Integer> list;
	public static void comb(int start,int cnt,int[] nums) {
		if(cnt == 3) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				sum += nums[number[i]];
			}
			if(is_prime(sum)) {
				if(!list.contains(sum)) {
					list.add(sum);	
				}
			}
			return;
		}else {
			for (int i = start; i < N; i++) {
				number[cnt] = i;
				comb(i+1,cnt+1,nums);
			}
		}
	}

}
