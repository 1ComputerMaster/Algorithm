package LeetCode;

public class Candy {
    public static void main(String[] args) {
        System.out.println("TC 1 : " + candy(new int[] {8,9,2,4,5,0,100,562,52,1,9,0,1,1,1,3,5,9,12,3,5,44,5,6,48}));
    }

    /**
     * @implNote
     * Two path greedy 방식으로 구현<br/>
     * 오른쪽에서 부터 왼쪽으로 스캔하며 값을 채우고 이후 왼쪽에서 오른쪽으로 스캔하면서 값을 채웁니다.<br/>
     * Time Complexity : O(n), Space Complexity : O(n)  <br/>
     * 장점 : 구현이 쉽다. <br/>
     * 단점 : Space Complexity O(n) 차지한다.  <br/>
     * 일반적인 해석은 증가 구간과 감소 구간을 카운트해서 이를 합산 후 중복으로 더해진 값을 빼는 형식입니다. <br/>
     * @param ratings
     * @return sum of ans[]
     *
     */
    public static int candy(int[] ratings) {
        int n = ratings.length;
        int[] ans = new int[n];
        if(ratings.length == 1){
            return 1;
        }

        if(ratings[0] > ratings[1]){
            ans[0] = 2;
        }else{
            ans[0] = 1;
        }

        for(int i = 1; i < n - 1; i++){
            if(ratings[i] > ratings[i - 1]){
                ans[i] = ans[i - 1] + 1;
            }else{
                ans[i] = 1;
            }
        }

        if(ratings[n - 2] >= ratings[n - 1]){
            ans[n - 1] = 1;
        }else{
            ans[n - 1] = ans[n - 2] + 1;
        }

        for(int i = n - 2; i > 0; i--){
            if(ratings[i] > ratings[i + 1]){
                if(ans[i - 1] > ans[i + 1] && ans[i] > ans[i - 1]){ //이미 더 큰 경우에만 셋팅, 
                    // 만일, 현재가 더 작을 시 그건 이미 이전의 순방향 탐색에서 정상 참작된 경우임
                    ans[i] = ans[i - 1] + 1;
                }else{
                    ans[i] = ans[i + 1] + 1;
                }
            }
        }

        if(ratings[0] > ratings[1]){
            ans[0] = ans[1] + 1;
        }

        int cnt = 0;
        for(int i = 0; i < n; i++){
            cnt += ans[i];
        }
        return cnt;
    }
}
