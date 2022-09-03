package simulation;

import java.util.Arrays;

public class PRO_양궁대회 {
	private static boolean[] isSel;
	private static int ans;
	private static int answer[];
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(9,new int[]{0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1})));
	}
	public static int[] solution(int n, int[] info) {
        answer = new int[11];
        isSel = new boolean[info.length];
        ans = -1;
        isSelect(0,n,info);
        if(array(answer)) {
        	answer = new int[1];
        	answer[0] = -1; 
        }
        return answer;
    }
	
	private static boolean array(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != 0) {
				return false;
			}
		}return true;
	}
	
    private static void isSelect(int r,int n, int[] info) {
    	if(r == info.length) {
    		int check = n;
		 	int t = 0;
		 	int newt = 0;
            for(int i = 0; i < info.length; i++) {
                if(info[i] != 0) {
                	t += (10-i);//어피치 점수 체크
                }
            }
		 	for(int i = 0; i < info.length; i++) {
		 		if(isSel[i]) {
		 			newt += (10-i);
    				n -= (info[i] + 1);// 1
    				if(info[i] != 0) {
    					t -= (10-i);
    				}
    				if(n < 0) {
    					return;
    				}
		 		}
		 	}
		 	// 어짜피 동점이나 더 작은 숫자면 지니깐..
		 	if((newt - t) <= 0) {
		 		return;
		 	}
		 	//이건 쓰기용이라 상관 없다.
		 	if((newt - t) >= ans) {
		 		if(ans == (newt-t)) {
		 			for(int i = info.length - 1; i >= 0; i--) {
		 				if(isSel[i]) {
		 					break;
		 				}
		 				if(answer[i] != 0) {
		 					return;
		 				}
		 			}
		 		}
    			int c = 0;
    			ans = newt-t;
	    		answer = new int[11];
    			for(int i = 0; i < info.length; i++) {
	    			if(isSel[i]) {
	    				answer[i] += (info[i] + 1);
	    				c += answer[i];
	    			}
	    		}
    			if(check > c) {
    				answer[10] = check-c;
    			}
		 	}
    		return;
    	}else {
    		isSel[r] = true;
    		isSelect(r+1,n,info);
    		isSel[r] = false;
    		isSelect(r+1,n,info);
    	}
    }
    
}
