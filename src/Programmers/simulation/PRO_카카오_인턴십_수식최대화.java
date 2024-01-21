package simulation;

import java.util.*;
public class PRO_카카오_인턴십_수식최대화 {
    static String expression;
    static long answer;
    public long solution(String exp) {
        answer = 0;
        expression = exp;
        boolean visited[] = new boolean[3];
        int number[] = new int[3];
        perm(visited,0,number);
        return answer;
    }
    public void perm(boolean visited[], int cnt,int number[]){
        if(cnt == 3){
            calc(number);
            return;
        }else{
            for(int i = 0; i < 3; i++){
                if(!visited[i]){
                    visited[i] = true;
                    number[cnt] = i;
                    perm(visited,cnt+1,number);
                    visited[i] = false;
                }
            }
        }
    }
    public void calc(int[] number){
        String[] arr = new String[3];
        for(int i = 0; i < 3; i++){
            if(number[i] == 0){
                arr[i] = "-";
            }else if(number[i] == 1){
                arr[i] = "*";
            }else{
                arr[i] = "+";
            }
        }
        StringBuilder post = new StringBuilder();
        List<Long> operandList = new LinkedList<>();
        List<String> operatorList = new LinkedList<>();
        for (int i = 0; i < expression.length(); i++) {
		if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*') {
			operandList.add(Long.parseLong(post.toString()));
			post = new StringBuilder();
			operatorList.add(String.valueOf(expression.charAt(i)));
		} else
			post.append(expression.charAt(i));
		}

		operandList.add(Long.parseLong(post.toString()));

		for (int i = 0; i < 3; i++) {
			String nowOperator = arr[i];

			while(operatorList.size() != 0){
				int index = operatorList.indexOf(nowOperator);

				if(index == -1)
					break;
				else{
					switch (nowOperator){
						case "+":
							operandList.add(index, operandList.get(index) + operandList.get(index + 1));
							break;
						case "-":
							operandList.add(index, operandList.get(index) - operandList.get(index + 1));
							break;
						case "*":
							operandList.add(index, operandList.get(index) * operandList.get(index + 1));
							break;
					}

					operandList.remove(index + 1);
					operandList.remove(index + 1);

					operatorList.remove(index);
				}
			}
		}
        answer = Math.max(answer, Math.abs(operandList.get(0)));
        }
    }
