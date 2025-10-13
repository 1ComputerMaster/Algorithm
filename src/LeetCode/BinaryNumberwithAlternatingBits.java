package LeetCode;

public class BinaryNumberwithAlternatingBits {
    public static void main(String[] args) {
        BinaryNumberwithAlternatingBits b = new BinaryNumberwithAlternatingBits();
        int n = 5;
        System.out.println(b.hasAlternatingBits(n)); // Should return true
    }
    public boolean hasAlternatingBits(int n) {
        int prevBit = -1; // 이전 비트를 저장할 변수, 초기값은 -1로 설정

        while(n > 0){
            int currentBit = n & 1;

            if(currentBit == prevBit){
                return false; // 이전 비트와 현재 비트가 같으면 false 반환
            }

            prevBit = currentBit;
            n >>= 1; // n을 오른쪽으로 한 비트 시프트
        }
        return true; // 모든 비트가 번갈아 나타나면 true 반환
    }

}
