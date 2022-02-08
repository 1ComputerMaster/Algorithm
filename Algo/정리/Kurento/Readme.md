# Kurento

- 전체 Web RTC 스택의 기능적  구현을 제공하는 미디어 서버

## Kurento를 사용하는 3가지 방법

1. 웹소켓 브라우저로 부터 직접적으로 Kurento JavaScript SDK를 사용하기
2. Java EE 서버에서 Kurento Java SDK를 사용하기
3. Node.js에 Kurento JavaScript SDK를 사용하기

## Media Server를 쓰는 이유

WebRTC는 본디 P2P 통신을 통해서 웹과 모바일 등등의 간의 RTC 기능을 제공하는 프로토콜과 APIs다.

1:N 통신을 위해서는 한명의 스트리머가 100만명의 뷰어를 감당 할 수 없으므로 중간 미디어 서버를 둔다.

그 미디어 서버는 **쿠렌토 미디어 서버**이다.

## 미디어 서버의 기능

1. Group Communications : 한 명의 스트리머가 방송을 시작 - > 그것을 참여자들에게 미디어 스트림을 배포한다.
2. Mixing : 여러 수신 스트림을 하나의 복합 스트림을 변환
3. Transcoding : 호환되지 않는 클라이언트들 간에 코덱 및 형식을 즉석에서 조정
4. Recording : 미디어에 들어오는 스트림을 영구적인 방식으로 저장


# 쿠렌토 서버 도커로 돌리기

```
docker pull kurento/kurento-media-server:latest

docker run -d --name kms --network host \
    kurento/kurento-media-server:latest

docker ps // 이것으로 올라갔는지 확인
```

쿠렌토의 TCP 8888번 포트와 UDP [5000,5050]을 연결해주는 과정이 필요하다.

```
docker run --rm \
    -p 8888:8888/tcp \
    -p 5000-5050:5000-5050/udp \
    -e KMS_MIN_PORT=5000 \
    -e KMS_MAX_PORT=5050 \
    kurento/kurento-media-server:latest
```

## 클라이언트에서 요청 보내기

깃에서 kurento-tutorial-java.git을 clone 한다.
```
git clone https://github.com/Kurento/kurento-tutorial-java.git

```

kurneto-one2many-call 디렉토리로 이동한다.
```
cd kurento-tutorial-java/kurento-one2many-call
```

master로 checkout합니다.
```
git checkout master
```

run
```
mvn -U clean spring-boot:run
```

https://localhost:8443/ 이동 후 presenter 누르면 카메라 확인 가능
