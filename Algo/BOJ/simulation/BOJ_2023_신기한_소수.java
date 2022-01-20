package simulation;

import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_2023_신기한_소수 {
	/*
	 * 부분 집합 처럼 선택해서 풀 수 있을줄 알았으나 선택하는 배열이 백트레킹 내부에서 꼬인다.
	 * 
	 * -> 선택하는 백트래킹을 응용해서 풀어보자
	 * 
	 * 
	 * 
	 * */
	static int N;
	static int prime[] = new int[] {2,3,5,7}; //처음 들어갈 수 한자리만 따졌을때도 소수가 되어야 하므로 이 수들이 들어간다.
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		for (int i = 0; i < prime.length; i++) {
			dfs(prime[i],1);
		}
	}
    private static void dfs(int num, int n) {
    	if(n == N) {
    		System.out.println(num);
    		return;
    	}
    	for (int i = 1; i < 10; i+=2) { //홀수만 더한다 소수에는 짝수 2밖에 없으니깐
			if(isPrime(num*10+i)) { 
				dfs((num*10+i),n+1);
			}
		}
	}
	public static boolean isPrime(int num){ //소수 인지 판별하는 알고리즘 -> 에라토스테네스의 체
        if(num == 1 || num == 2) {
        	return true;
        }
		for(int i=2; i*i<=num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}
