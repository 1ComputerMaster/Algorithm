# 1. 신기한 소수

- 백 트래킹 문제였습니다.

- 간단하게 부분 집합의 선택하고 안 하고를 반복 하는 것으로 생각하고 구현하였으나 다음번에 체킹 할 때 배열을 새로 초기화 해야 하므로 엄청나게 많은 횟수를 돌거나 반복적으로 갔던 곳을 또 갈 위험이 있었습니다. (한 번 앞에서 선택 한 것을 다시 선택 할 수 없었음 -> 부분집합 문제 처럼 풀 수 없음)

- 그래서 소수의 성질을 이용하여 바로 바로 숫자를 만들고 소수를 판별하는 방식으로 구현하게 되었습니다.

- 신기한 소수 특징상 자릿수의 모든 숫자가 소수가 되어야 하기 때문에 처음으로 들어가는 숫자를 소수로 정해줬습니다.

- 들어가는 수에 대해서 각 자리값에 대해서 홀수 값을 차례로 더 해주면서 소수인지 판별하는 알고리즘으로 제작 되었습니다.

- isPrime -> 소수의 증명 이용 (소수는 자기 자신과 1을 제외하고는 약수가 없다.)

핵심 구현 부분
```
for(int i = 1; i< 10; i+=2){
    if(isPrime(num*10+i)){
        dfs(num*10+i,n+1);
    }
}
```

전체 구현 부분

```
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
	public static boolean isPrime(int num){ //소수 인지 판별하는 알고리즘 -> 각 수의 제곱근까지만 약수를 판별 
	//-> 어짜피 약수 나열 했을때 반만 계산해도 된다.
        if(num == 1 || num == 2) {
        	return true;
        }
		for(int i=2; i*i<=num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }



```

