package Programmers.simulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PRO_KAKAO_WINTER_개인정보_수집_유효기간 {
    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        PRO_KAKAO_WINTER_개인정보_수집_유효기간 sol = new PRO_KAKAO_WINTER_개인정보_수집_유효기간();

        int[] ans = sol.solution(today,terms,privacies);
        System.out.println(Arrays.toString(ans));
    }
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        List<Integer> ans = new ArrayList<>();
        String[] todays = today.split("\\.");
        int todayYear = Integer.parseInt(todays[0]);
        int todayMonth = Integer.parseInt(todays[1]);
        int todayDay = Integer.parseInt(todays[2]);
        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            for (String term : terms) {
                String[] policy = term.split(" ");
                if (privacy[1].equals(policy[0])) {
                    // policy[1]을 달으로 기준으로 더한다
                    String[] ymd = privacy[0].split("\\.");
                    //만일 month > 12 이상이라면?, 만일, 1일에 시작되는 달이라서 +1 했을 때 같은 달의 28일이 된다면?
                    int year, month, day;
                    if (Integer.parseInt(ymd[2]) == 1) {
                        if (Integer.parseInt(policy[1]) + Integer.parseInt(ymd[1]) > 12) {
                            year = Integer.parseInt(ymd[0]) + (Integer.parseInt(policy[1]) + Integer.parseInt(ymd[1]) - 1) / 12;
                            month = (Integer.parseInt(policy[1]) + Integer.parseInt(ymd[1]) - 1) % 12 + 1;
                            day = 1;
                        } else {
                            year = Integer.parseInt(ymd[0]);
                            month = Integer.parseInt(ymd[1]) + Integer.parseInt(policy[1]);
                            day = 1;
                        }
                    } else {
                        if (Integer.parseInt(policy[1]) + Integer.parseInt(ymd[1]) > 12) {
                            year = Integer.parseInt(ymd[0]) + (Integer.parseInt(policy[1]) + Integer.parseInt(ymd[1]) - 1) / 12;
                            month = (Integer.parseInt(policy[1]) + Integer.parseInt(ymd[1]) - 1) % 12 + 1;
                            day = Integer.parseInt(ymd[2]) - 1;
                        } else {
                            year = Integer.parseInt(ymd[0]);
                            month = Integer.parseInt(ymd[1]) + Integer.parseInt(policy[1]);
                            day = Integer.parseInt(ymd[2]) - 1;
                        }
                    }
                    //대소 비교 시작

                    if (todayYear > year) {
                        ans.add(i + 1);
                    } else if (todayYear == year) {
                        if (todayMonth > month) {
                            ans.add(i + 1);
                        } else if (todayMonth == month) {
                            if (todayDay > day) {
                                ans.add(i + 1);
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }
}
