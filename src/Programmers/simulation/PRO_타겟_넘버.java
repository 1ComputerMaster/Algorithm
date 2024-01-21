package simulation;

public class PRO_타겟_넘버 {
    static boolean select[];
    static int ans;
    public int solution(int[] numbers, int target) {
        ans = 0;
        select = new boolean[numbers.length];

        isSelected(0,numbers,numbers.length,target);
        return ans;
    }
    private static void isSelected(int cnt,int[] numbers,int n,int target){
        if(cnt == n){
            int count = 0;
            int arr[] = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = numbers[i];
            }
            for(int i = 0; i < n; i++){
                if(select[i]){
                    arr[i] = -arr[i];
                }
            }
            for(int i = 0; i < n; i++){
                count += arr[i];
            }
            if(count == target){
                ans++;
            }
        }else{
            select[cnt] = true;
            isSelected(cnt+1,numbers,n,target);
            select[cnt] = false;
            isSelected(cnt+1,numbers,n,target);
        }
    }
}
