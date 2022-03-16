package simulation;

import java.util.ArrayList;

public class PRO_로또의_최고_순위와_최저_순위 {

	public static void main(String[] args) {
		
	}
	static ArrayList<Integer> lotto;
	static ArrayList<Integer> win;
	static int ans;
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        lotto = new ArrayList<>();
        win = new ArrayList<>();
        ans = 0;
        int zero = 0;
        for (int i = 0; i < lottos.length; i++) {
        	if(lottos[i] == 0) {
        		zero += 1;
        	}
			lotto.add(lottos[i]);
			win.add(win_nums[i]);
		}
        int cnt = 0;
        for (int i = 0; i < win.size(); i++) {
        	if(lotto.contains(win.get(i))) {
        		
        		cnt++;
        	}
		}
        if(cnt == 2) {
        	answer[0] = 5;
        }else if(cnt == 3) {
        	answer[0] = 4;
        }else if(cnt == 4) {
        	answer[0] = 3;
        }else if(cnt == 5) {
        	answer[0] = 2;
        }else if(cnt == 6) {
        	answer[0] = 1;
        	answer[1] = 1;
        	return answer;
        }else {
        	answer[0] = 6;
        }
        
        int num[] = new int[zero];
        comb(1,0,zero,num);
        
        ans += cnt;
        if(ans == 2 ) {
        	answer[1] = 5;
        }else if(ans == 3) {
        	answer[1] = 4;
        }else if(ans == 4) {
        	answer[1] = 3;
        }else if(ans == 5) {
        	answer[1] = 2;
        }else if(ans == 6) {
        	answer[0] = 1;
        	answer[1] = 1;
        	return answer;
        }else {
        	answer[1] = 6;
        }
        
        return answer;
    }
	private void comb(int start, int n, int zero,int [] num) {
		if(n == zero) {
			int sum = 0;
			for (int i = 0; i < num.length; i++) {
				for (int j = 0; j < win.size(); j++) {
					if(num[i] == win.get(j)) {
						sum += 1;
					}
				}
			}
			ans = Math.max(sum, ans);
			return;
		}else {
			for (int i = start; i <= 45; i++) {
				num[n] = i;
				comb(i+1,n+1,zero,num);
			}
		}
	}
}
