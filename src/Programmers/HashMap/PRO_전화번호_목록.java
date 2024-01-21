package Programmers.HashMap;

import java.util.*;

public class PRO_전화번호_목록 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String, Integer> map = new HashMap<>(); // 2. 모든 전화번호를 HashMap에 넣는다.
        for (int i = 0; i < phone_book.length; i++) 
            map.put(phone_book[i], i); 
        // 3. 모든 전화번호의 substring이 HashMap에 존재하는지 확인한다. 
        for (int i = 0; i < phone_book.length; i++) 
            for (int j = 0; j < phone_book[i].length(); j++) 
                if (map.containsKey(phone_book[i].substring(0, j))) 
                    return false;
        return answer;
    }
}