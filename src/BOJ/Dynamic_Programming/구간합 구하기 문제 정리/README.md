# 1. 구간합 구하기 문제

- 문제를 정리하자면 100000*1000*1000으로 이미 컴퓨터에서 1초 이상의 시간이 걸린다. Brute force로는 절대 풀 수 없으며 문제를 DP로 이해 해야 한다.


## 1 - 1. DP[i][j] 누적합을 만드는 점화식
dp[i][j] = dp[i-1] + dp[i][j-1] - dp[i-1][j-1] + map[i][j];

이는 정리하자면 이와 같다

![image](https://user-images.githubusercontent.com/87481266/148666980-24723c09-d7a8-4682-a812-d0e02940292c.png)


## 1 - 2. 문제에서 질문한 넓이를 구하는 점화식

![image](https://user-images.githubusercontent.com/87481266/148667268-7cc15d84-25ea-480f-96c5-bf80cdcb54ce.png)
