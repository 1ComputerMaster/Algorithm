package LeetCode;

public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {1, 2, 3};
        int[] result = plusOne(digits);
        for (int digit : result) {
            System.out.print(digit + " ");
        }
    }
    // Beat 100%
    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newDigits = new int[n + 1];
        newDigits[0] = 1;
        return newDigits;
    }
    //매우 느림
    public int[] deprecatedPlusOne(int[] digits) {
        String num = "";
        for(int i = 0; i < digits.length; i++){
            num += (digits[i] + "");
        }
        int size = digits.length - 1;
        while(size >= 0){
            if(digits[size] != 9)
            {
                break;
            }
            size--;
        }

        if(size == -1){
            int[] ans = new int[num.length() + 1];
            for(int i = 0; i < num.length() + 1; i++){
                ans[i] = 0;
            }
            ans[0] = 1;
            return ans;
        }
        if(size == 0){
            int[] ans = new int[num.length()];
            for(int i = 0; i < num.length(); i++){
                ans[i] = 0;
            }
            ans[0] = (num.charAt(0) - '0') + 1;
            return ans;
        }


        int[] ans = new int[num.length()];
        ans[size] = (num.charAt(size) - '0') + 1;
        for(int i = 0; i < size; i++){
            ans[i] = num.charAt(i) - '0';
        }

        for(int i = size + 1; i < num.length(); i++){
            ans[i] = 0;
        }
        return ans;

    }

}
