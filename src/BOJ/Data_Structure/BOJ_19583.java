package BOJ.Data_Structure;

import java.io.*;
import java.util.*;

public class BOJ_19583 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 개강총회 시작, 끝, 스트리밍 종료 시간 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        String S = st.nextToken();
        String E = st.nextToken();
        String Q = st.nextToken();
        String startTime[] = S.split(":");
        String endTime[] = E.split(":");
        String questTime[] = Q.split(":");

        // Set을 이용해 입장, 퇴장 확인
        Set<String> attendeesBeforeStart = new HashSet<>();
        Set<String> attendeesAfterEnd = new HashSet<>();

        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            StringTokenizer token = new StringTokenizer(line);
            String time = token.nextToken();
            String name = token.nextToken();

            String[] currentTime = time.split(":");
            if(compareTime(currentTime, startTime) <= 0){
                attendeesBeforeStart.add(name);
            } else if (compareTime(currentTime, endTime) >= 0 && compareTime(currentTime, questTime) <= 0){
                if(attendeesBeforeStart.contains(name))
                    attendeesAfterEnd.add(name);
            }
        }
        System.out.println(attendeesAfterEnd.size());
    }

    private static int compareTime(String[] src, String[] dest) {
        int destHour = Integer.parseInt(dest[0]);
        int srcHour = Integer.parseInt(src[0]);

        int destMin = Integer.parseInt(dest[1]);
        int srcMin = Integer.parseInt(src[1]);

        return srcHour != destHour ?
                Integer.compare(srcHour,destHour) : Integer.compare(srcMin, destMin);
    }
}
