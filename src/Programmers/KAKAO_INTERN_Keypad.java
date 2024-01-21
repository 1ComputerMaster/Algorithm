
public class KAKAO_INTERN_Keypad {
	  static class Data{
	       int x;
	       int y;
	       Data(int x,int y){
	           this.x = x;
	           this.y = y;
	       }
	   }
	    static Data arr[]={new Data(1,4),new Data(0,1),new Data(1,1),new Data(2,1)
	                       ,new Data(0,2),new Data(1,2),new Data(2,2)
	                       ,new Data(0,3),new Data(1,3),new Data(2,3)
	                       ,new Data(0,4),new Data(2,4)};


	    public String solution(int[] numbers, String hand) {
	        String answer = "";
	        Data right = arr[11];
	        Data left = arr[10];
	        for(int i = 0;i<numbers.length;i++)
	        {    
	            if(numbers[i] == 1 ||numbers[i] == 4 || numbers[i] == 7)
	            {
	                answer+="L";
	                left = arr[numbers[i]];
	                continue;
	            }
	            else if(numbers[i] == 3 ||numbers[i] == 6 || numbers[i] == 9)
	            {
	                answer+="R";
	                right = arr[numbers[i]];
	                continue;
	            }else{ //모든 다른 수의 경우들
	               int left_abs = Math.abs(arr[numbers[i]].x - left.x) + Math.abs(arr[numbers[i]].y - left.y);
	                int right_abs = Math.abs(arr[numbers[i]].x - right.x) + Math.abs(arr[numbers[i]].y - right.y);
	                if(Math.abs(right_abs) > Math.abs(left_abs)){
	                    answer += "L";
	                    left = arr[numbers[i]];
	                }else if(Math.abs(right_abs) < Math.abs(left_abs)){
	                    answer += "R";
	                    right = arr[numbers[i]];
	                }else{
	                    if(hand.equals("right")){
	                        answer+="R";
	                        right = arr[numbers[i]];
	                        }
	                    else{
	                        answer+="L";
	                        left = arr[numbers[i]];
	                    }
	                }
	            }
	        }
	        return answer;
	    }
	}
