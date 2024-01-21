package simulation;

import java.util.*;
class PRO_주차요금 {
	public static void main(String[] args) {
		int[] fees = {180, 5000, 10, 600};
		String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
		System.out.println(Arrays.toString(solution(fees, records)));
	}
    static ArrayList<String> list;//차량 번호를 저장
    static ArrayList<String> car; //map에서 순서 대로 꺼내기용
    static int check[];//들어가는 시간을 저장
    public static int[] solution(int[] fees, String[] records) {
        int[] answer;
        String t = "";
        check = new int[records.length];
        list = new ArrayList<String>();
        car = new ArrayList<String>();
        for(int i = 0; i < records.length; i++){
            t = records[i].substring(0,records[i].indexOf(" "));
            String hour = t.substring(0,t.indexOf(":"));
            String min = t.substring(t.indexOf(":")+1,t.length());
            int h = Integer.parseInt(hour)*60;
            int m = Integer.parseInt(min);
            check[i] = h+m; //시간 저장
            t = records[i].substring(records[i].indexOf(" ")+1,records[i].lastIndexOf(" "));//차량 번호
            list.add(t); // 차량 번호를 저장
        }
        boolean go = false;
        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0; i < records.length; i++){
            go = false;
            int time = 0;
            for(int j = i+1; j < records.length; j++){
                if(list.get(i).equals(list.get(j)) && check[i] != -1){
                    time = check[j] - check[i]; //시간 저장
                    check[i] = -1;
                    check[j] = -1;
                    go = true;
                    map.put(list.get(i),(map.getOrDefault(list.get(i),0)+time) ); //없었으면 시간 넣음
                    break; // break 안하면 다음것도 체킹해버림
                }
            }
            if(!go && check[i] != -1){ //23:59랑 비교해서 뺌
                time = (1439-check[i]);
                map.put(list.get(i),(map.getOrDefault(list.get(i),0)+time));
            }
            if(!car.contains(list.get(i))){ //가지지 않았던 값이면
                car.add(list.get(i));
            }
        }
        Collections.sort(car);
        answer = new int[car.size()];
        for(int i = 0; i < car.size(); i++){
            answer[i] = map.get(car.get(i));
            if(fees[0] < answer[i]) {
            	answer[i] = (int) (fees[1] + Math.ceil((double) (answer[i] - fees[0]) / fees[2]) * fees[3]);
            }else {
            	answer[i] = fees[1];
            }
        }
            // 이것을 가공하여 쓴다.
        
        return answer;
    }
}
