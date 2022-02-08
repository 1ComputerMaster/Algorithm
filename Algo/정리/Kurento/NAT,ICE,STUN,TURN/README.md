# NAT(Network Address Translation)

통상적인 네트워크에서 데이터를 주고 받기 위해서는 Public IP가 필요하다.

**NAT는 Private IP를 Public IP로 1:1 대응히켜 변환하는 장치**

하지만 WebRTC 통신은 P2P 통신인데 보내고 받는 Peer 주소가 필요하다.

NAT의 방화벽은 어떡할까? **STUN서버와 TURN 서버**로 문제를 해결 할 수 있다.

# ICE(Interactive Connectivity Establishment)

ICE는 두 단말기가 서로 통신 할 수 있는 최적의 경로를 찾아주는것을 도와주는 프레임 워크이다.

## 왜 ICE를 사용해야 하는가?

모든 단말은 다양하기에 Peer A to Peer B 가 단순히 연결 되어지지 않는다. 방화벽이 있으면 방화벽을 통과해야하고 단말의 퍼블릭 IP가 없다면 유일한 주소값을 할당해야하고 등등...

ICE 프로세스를 사용하면 NAT이 통신을 위해 필요한 포트는 모두 열어두고 두 엔드 포인트 모두 다 연결 할 수 있는 IP 주소, 포트에 대한 완전한 정보를 갖게 된다.

이때 STUN과 TURN 서버가 쓰인다.

# STUN(Session Traversal Utilities for NAT)

**해당 Peer의 공인 IP 주소를 보내어 주는 역할**

# TURN(Traversal Using Relays around NAT)

NAT 방화벽이 엄격하여 사설망으로 통신 할 때 쓰인다고 한다.
