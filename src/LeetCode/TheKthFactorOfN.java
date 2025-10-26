package LeetCode;

public class TheKthFactorOfN {
    public static void main(String[] args) {
        int n = 12;
        int k = 3;
        TheKthFactorOfN sol = new TheKthFactorOfN();
        int ans = sol.kthFactor(n, k);
        System.out.println(ans);
    }
    public int kthFactor(int n, int k) {
        int count = 0;
        for(int i = 1; i <= n; i++){
            if(n % i == 0){
                count++;
                if(count == k){
                    return i;
                }
            }
        }
        return -1;
    }
}
