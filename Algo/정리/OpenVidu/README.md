# Open Vidu Tutorial
```
docker -v 
npm -v
```

open vidu git clone
```
git clone https://github.com/OpenVidu/openvidu-tutorials.git -b v2.18.0
```
웹 서버 설치

```
sudo npm install -g http-server
```

해당 서버로 튜토리얼 올림

```
http-server openvidu-tutorials/openvidu-hello-world/web
```

```
# WARNING: this container is not suitable for production deployments of OpenVidu Platform
# Visit https://docs.openvidu.io/en/stable/deployment

docker run -p 4443:4443 --rm -e OPENVIDU_SECRET=MY_SECRET openvidu/openvidu-server-kms:2.18.0

```

http://localhost:4443 에서 크롬 고급창에서 접근 허용 후

http://localhost:8080 가서 확인 하기 


## Group Call 만들기 Open Vidu

위에서 설치 받은 git clone 위치에서 이동
```
cd openvidu-tutorials/openvidu-js-java

mvn package exec:java
```

docker 이미지 run

```
docker run -p 4443:4443 --rm -e OPENVIDU_SECRET=MY_SECRET openvidu/openvidu-server-kms:2.18.0
```

그 후 docker 까지 올라가면

https://localhost:5000 들어가서 publisher와 subscriber로 확인 튜토리얼 상에서 제공하는 아이디 비밀 번호로 들어가면 됨