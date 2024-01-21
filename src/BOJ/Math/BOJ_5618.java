package BOJ.Math;
import java.util.*;
import java.io.*;

public class BOJ_5618 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i= 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        check(arr);
    }

    private static void check(int[] arr) {
        for (int i = 1; i <= arr[0]; i++) {
            boolean check = true;
            for(int j = 0; j < arr.length; j++) {
                if(arr[j] % i == 0){
                    continue;
                }else{
                    check = false;
                }
            }
            if(check == true){
                System.out.println(i);
            }
        }
    }
}
