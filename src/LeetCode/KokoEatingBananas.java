package LeetCode;

public class KokoEatingBananas {
    public static void main(String[] args) {
        KokoEatingBananas obj = new KokoEatingBananas();
        int[] piles = {3,6,7,11};
        int h = 8;
        System.out.println(obj.minEatingSpeed(piles, h)); // Output: 4
    }

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        int result = right;
        while(left < right){
            int mid = (left + right) / 2;
            if(canTake(mid, piles, h)){
                right = mid;
                result = Math.min(result, mid);
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
    private boolean canTake(int k, int[] piles, int h){
        long take = 0;
        for (int pile : piles) {
            if(pile % k == 0){
                take += pile / k;
            } else {
                take += (pile / k) + 1;
            }
        }
        return take <= h;
    }
}
