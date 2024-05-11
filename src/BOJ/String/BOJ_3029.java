package BOJ.String;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class BOJ_3029 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LocalTime currentTime = LocalTime.parse(sc.nextLine());
        LocalTime throwTime = LocalTime.parse(sc.nextLine());

        long secondsBetween = ChronoUnit.SECONDS.between(currentTime, throwTime);
        if (secondsBetween < 0) {
            secondsBetween += 24 * 60 * 60;
        }

        LocalTime waitTime = LocalTime.ofSecondOfDay(secondsBetween);
        System.out.printf("%02d:%02d:%02d\n", waitTime.getHour(), waitTime.getMinute(), waitTime.getSecond());
    }

}
