package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class UndergroundSystem {
    class CheckOutInfo{
        int personCnt;
        int time;
        public CheckOutInfo(int personCnt, int time){
            this.personCnt = personCnt;
            this.time = time;
        }
    }
    class StationInfo{
        String startStation;
        int startTime;
        public StationInfo(String startStation, int startTime){
            this.startStation = startStation;
            this.startTime = startTime;
        }
    }

    Map<Integer, StationInfo> checkInMap;
        Map<String, CheckOutInfo> checkoutMap;
        public UndergroundSystem() {
            checkInMap = new HashMap<>();
            checkoutMap = new HashMap<>();
        }

        public void checkIn(int id, String stationName, int t) {
            checkInMap.put(id, new StationInfo(stationName, t));
        }

        public void checkOut(int id, String stationName, int t) {
            if(checkInMap.containsKey(id)){
                StationInfo stationInfo = checkInMap.get(id);
                String key = stationInfo.startStation+":"+stationName;
                checkoutMap.computeIfAbsent(key, k -> new CheckOutInfo(0, 0));
                CheckOutInfo checkout = checkoutMap.get(key);
                checkout.personCnt++;
                checkout.time += (t - stationInfo.startTime);
            }
        }

        public double getAverageTime(String startStation, String endStation) {
            String key = startStation+":"+endStation;
            if(checkoutMap.containsKey(key)){
                CheckOutInfo infos = checkoutMap.get(key);
                return ((double) infos.time / (double) infos.personCnt);
            }
            return 0.0;
        }

        public static void main(String[] args) {
            UndergroundSystem undergroundSystem = new UndergroundSystem();
            undergroundSystem.checkIn(45, "Leyton", 3);
            undergroundSystem.checkIn(32, "Paradise", 8);
            undergroundSystem.checkIn(27, "Leyton", 10);
            undergroundSystem.checkOut(45, "Waterloo", 15);
            undergroundSystem.checkOut(27, "Waterloo", 20);
            undergroundSystem.checkOut(32, "Cambridge", 22);
            System.out.println(undergroundSystem.getAverageTime("Paradise", "Cambridge"));
            System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));
            undergroundSystem.checkIn(10, "Leyton", 24);
            System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));
            undergroundSystem.checkOut(10, "Waterloo", 38);
            System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));
        }
    }
