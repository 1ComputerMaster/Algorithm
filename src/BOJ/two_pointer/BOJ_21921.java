package BOJ.two_pointer;

import java.util.Scanner;

public class BOJ_21921 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int X = sc.nextInt();

        int [] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        int left = 0;
        int right = X - 1;
        int sum = 0;
        int count = 1;
        int max = 0;
        for(int i = 0; i <= right; i++){
            sum += arr[i];
        }
        max = sum;

        while(right < N - 1){

            sum -= arr[left];
            sum += arr[right + 1];

            if(max < sum){
                max = sum;
                count = 1;
            }
            else if (max == sum){
                count++;
            }
            left++;
            right++;
        }
        if(max == 0){
            System.out.println("SAD");
        }else {
            System.out.println(max + " \n" + count);
        }
    }
}
