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
        int right = piles.length - 1;
        for(int i = 0; i < piles.length; i++){
            right = Math.max(piles[i], right);
        }
        int k = Integer.MAX_VALUE;
        while(left <= right){
            int mid = (left + right) / 2;
            if(canTake(h, piles, mid)){
                right = mid - 1;
                k = Math.min(mid, k);
            } else {
                left = mid + 1;
            }
        }
        return k;
    }
    private boolean canTake(int h, int[] piles, int t){
        long take = 0;
        for(int pile : piles){
            if(pile % t != 0)
            {
                take += ((pile / t) + 1);
            }else{
                take += (pile / t);
            }
        }
        if(h >= take){
            return true;
        }
        return false;
    }
}
