package BOJ.Dynamic_Programming;

import java.util.Scanner;

public class BOJ_2876 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] grades = new int[N][2];
        for (int i = 0; i < N; i++) {
            grades[i][0] = sc.nextInt();
            grades[i][1] = sc.nextInt();
        }

        int maxCount = 0;
        int gradeToUse = 6; // 임의의 큰 수로 초기화

        for (int grade = 1; grade <= 5; grade++) {
            int count = 0;
            boolean check = false;
            for (int[] desk : grades) {
                if (desk[0] == grade || desk[1] == grade) {
                    count++;
                    check = true;
                }else {
                    check = false;
                }
                if(!check){
                    count = 0;
                }
                if (count > maxCount && check) {
                    maxCount = count;
                    gradeToUse = grade;
                }
            }
        }

        System.out.println(maxCount + " " + gradeToUse);
        sc.close();
    }
}
