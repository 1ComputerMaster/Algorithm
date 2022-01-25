# 1. Road Map

## 1 - 1. 서버 구축 방식
    
    - 온 프레미스 방식
        
        일일이 직접 구현

    - 클라우드 방식

        다른 기업에서 지원하는 서버를 이용해서 서버를 구현
    
## 1 - 2. CLI 환경에서 서버 구축 방식

    Putty 나 MobaXterm

## 1 - 3. 기본 세팅 서버 구축 방식

    DB - MySQL, MariaDB, ...

    웹 서버 - NGINX

    배포 - Docker

    ※ 22번 포트의 조작은 조심하여야 한다.

## 1 - 4. 기록

    NGINX 설정과 해결방안들을 하나하나씩 기록하면서 나아가자
    - notion 이용

# 2. AWS EC2 사용하기

## 2 - 1. AWS EC2 접속하기

    - MobaXterm 이용
        
        Session -> SSH -> Remote host -> ubuntu -> cert.pmm 암호 등록

        
## 2 - 2. Local Workbench에 Server DB 연결하기

    - MySQL 연결

        Hostname URI를 넣고 Username : 지정 password : 지정


## 2 - 3. NGINX 기본 설정

    - vi /etc/nginx/sites-avaliable/default

## 2 - 4. 수동 배포하기

    - jar 파일
    - dist 파일
    - java -jar solver-backend 0.0.1 ....

## 배포 명령어 정리


![image](https://user-images.githubusercontent.com/87481266/150916614-ca6756a1-6ea7-4ba8-9006-507c4c800593.png)
