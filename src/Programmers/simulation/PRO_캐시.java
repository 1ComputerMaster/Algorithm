package simulation;

public class PRO_캐시 {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if(cacheSize > 0){
            String cache[] = new String[cacheSize];
            int when[] = new int[cacheSize];
            boolean check = false;
            for(int j = 0; j < cities.length; j++){
                check = false;
                for(int i = 0; i < cacheSize; i++){
                    if((cities[j].toUpperCase()).equals(cache[i])){
                        answer++;
                        check = true;
                        when[i] = -1;//최근에 참조 됨
                        break;
                    }
                }
                for(int i = 0; i < cacheSize; i++){
                    when[i] += 1;
                }
                if(!check){
                    answer+=5;
                    int max = -100;
                    int idx = 0;
                    for(int i = 0; i < cacheSize; i++){
                        if(when[i] > max){
                            max = when[i];
                            idx = i;
                        }
                    }
                    cache[idx] = (cities[j].toUpperCase());
                    when[idx] = 0;
                }
            }
        }
        else{
            answer = cities.length*5;
        }
        return answer;
    }
}