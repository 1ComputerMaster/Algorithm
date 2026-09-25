package LeetCode;

/**
 * LeetCode 43. Multiply Strings
 *
 * <p><b>English problem statement</b></p>
 *
 * <p>
 * Given two non-negative integers {@code num1} and {@code num2}, represented as
 * strings, return their product as a string.
 * </p>
 *
 * <p>
 * You must not use a built-in big integer library, and you must not convert the
 * entire input strings directly to integer types.
 * </p>
 *
 * <p><b>Korean problem statement</b></p>
 *
 * <p>
 * 음이 아닌 두 정수 {@code num1}, {@code num2}가 문자열로 주어진다.<br>
 * 두 수를 곱한 결과를 문자열로 반환하라.
 * </p>
 *
 * <p>
 * {@code BigInteger}와 같은 큰 정수 라이브러리를 사용할 수 없으며,<br>
 * 입력 문자열 전체를 정수 자료형으로 직접 변환해서도 안 된다.
 * </p>
 *
 * <p><b>Constraints</b></p>
 *
 * <p>
 * {@code 1 <= num1.length, num2.length <= 200}<br>
 * {@code num1}과 {@code num2}는 숫자로만 구성된다.<br>
 * 입력 자체가 {@code "0"}인 경우를 제외하면 leading zero는 없다.
 * </p>
 */
public final class MultiplyStrings {

    public String multiply(String num1, String num2) {
        int lengthOne = num1.length();
        int lengthTwo = num2.length();

        if (lengthOne > lengthTwo) {
            return carryBit(num1, num2);
        }
        return carryBit(num2, num1);
    }

    private String carryBit(String big, String small) {
        int bigL = big.length();
        int smallL = small.length();

        if (big.equals("0") || small.equals("0")) {
            return "0";
        }

        char[] arr1 = big.toCharArray();
        char[] arr2 = small.toCharArray();

        // bigL자리 * smallL자리의 결과는 최대 bigL + smallL자리
        int[] result = new int[bigL + smallL];

        for (int i = bigL - 1; i >= 0; i--) {
            for (int j = smallL - 1; j >= 0; j--) {
                int bigValue = arr1[i] - '0';
                int smallValue = arr2[j] - '0';

                int cur = bigValue * smallValue;

                // i, j 자리의 곱이 들어갈 위치
                int carryIndex = i + j;
                int valueIndex = i + j + 1;

                cur += result[valueIndex];

                result[valueIndex] = cur % 10;
                result[carryIndex] += cur / 10;
            }
        }
        StringBuilder sb = new StringBuilder();

        for (int value : result) {
            if (sb.isEmpty() && value == 0) {
                continue;
            }
            sb.append(value);
        }
        return sb.isEmpty() ? "0" : sb.toString();


    }

    public static void main(String[] args) {
        MultiplyStrings solution = new MultiplyStrings();

        run("single-digit multiplication", () ->
                equal("6", solution.multiply("2", "3")));

        run("LeetCode sample with multiple digits", () ->
                equal("56088", solution.multiply("123", "456")));

        run("multiplication by zero", () ->
                equal("0", solution.multiply("9133", "0")));

        run("carry across several positions", () ->
                equal("9801", solution.multiply("99", "99")));

        run("small argument is longer", () ->
                equal("408", solution.multiply("12", "34")));

        run("result exceeds long range", () ->
                equal(
                        "9999999999999999999800000000000000000001",
                        solution.multiply("99999999999999999999", "99999999999999999999")
                ));
    }

    private static void run(String name, Runnable test) {
        try {
            test.run();
            System.out.println("[PASS] " + name);
        } catch (Throwable error) {
            System.out.println("[FAIL] " + name);
            System.out.println("       " + error);
        }
    }

    private static void equal(String expected, String actual) {
        if (!expected.equals(actual)) {
            throw new AssertionError("expected=" + expected + ", actual=" + actual);
        }
    }

    private MultiplyStrings() {
    }
}
