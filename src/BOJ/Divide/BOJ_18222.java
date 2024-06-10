package BOJ.Divide;
import java.util.Scanner;
public class BOJ_18222 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long k = scanner.nextLong();
        scanner.close();
        System.out.println(findThueMorse(k - 1));
    }
    private static int findThueMorse(long k) {
        if (k == 0) {
            return 0;
        }
        long len = 1;
        while (len * 2 <= k) {
            len *= 2;
        }
        return 1 - findThueMorse(k - len);
    }
}
