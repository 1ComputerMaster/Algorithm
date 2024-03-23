package BOJ.Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1106 {
    static class City {
        int money;
        int numOfCostomer;
        public City(int money, int numOfCostomer){
            this.money = money;
            this.numOfCostomer = numOfCostomer;
        }
    }
    static City[] cities;
    static int dp[];
    static int C,N;
    private static void input() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");

        C = Integer.parseInt(tk.nextToken());
        N = Integer.parseInt(tk.nextToken());

        int money,numOfCostomer = 0;

        cities = new City[N];
        dp = new int[C + 1000001];

        for (int i = 0; i < N; i++){
            tk = new StringTokenizer(in.readLine()," ");
            money = Integer.parseInt(tk.nextToken());
            numOfCostomer = Integer.parseInt(tk.nextToken());
            cities[i] = new City(money,numOfCostomer);
        }
    }
    public static void main(String[] args) throws Exception{
        int ans = Integer.MAX_VALUE;
        input();

        for (int j = 0; j < N; j++){
            int k = cities[j].money;
            for (int i = 0; i < dp.length; i++){
                if(i - k < 0){
                    continue;
                }
                if(dp[i] < dp[i - k] + cities[j].numOfCostomer){
                    dp[i] = dp[i - k] + cities[j].numOfCostomer;
                }
                if(dp[i] >= C && ans > i){
                    ans = i;
                }
            }
        }
        System.out.println(ans);
    }
}
