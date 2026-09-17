package LeetCode;

import java.util.TreeMap;

public class SlidingWindowMedian {
    public static void main(String[] args) {
        SlidingWindowMedian solution = new SlidingWindowMedian();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        double[] medians = solution.medianSlidingWindow(nums, k);
        for (double median : medians) {
            System.out.print(median + " ");
        }
        // Expected output: 1.0 -1.0 -1.0 3.0 5.0
    }


    // 작은 절반
    private final TreeMap<Integer, Integer> left = new TreeMap<>();

    // 큰 절반
    private final TreeMap<Integer, Integer> right = new TreeMap<>();

    // TreeMap.size()는 서로 다른 key 개수이므로
    // 실제 원소 개수를 별도로 관리한다.
    private int leftSize = 0;
    private int rightSize = 0;

    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] answer = new double[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);

            // 윈도우 크기가 k를 넘어가면 가장 오래된 숫자를 제거한다.
            if (i >= k) {
                remove(nums[i - k]);
            }

            // 윈도우가 완성된 시점부터 중앙값을 기록한다.
            if (i >= k - 1) {
                answer[i - k + 1] = getMedian(k);
            }
        }

        return answer;
    }

    private void add(int value) {
        /*
         * left가 비어 있거나 value가 left의 최댓값 이하라면
         * 작은 절반인 left에 넣는다.
         */
        if (leftSize == 0 || value <= left.lastKey()) {
            addToMap(left, value);
            leftSize++;
        } else {
            addToMap(right, value);
            rightSize++;
        }

        balance();
    }

    private void remove(int value) {
        // 어느 그룹에 들어 있는지 직접 확인한다.
        if (left.containsKey(value)) {
            removeFromMap(left, value);
            leftSize--;
        } else {
            removeFromMap(right, value);
            rightSize--;
        }

        balance();
    }

    private void balance() {
        /*
         * 유지할 조건:
         *
         * leftSize == rightSize
         * 또는
         * leftSize == rightSize + 1
         */

        while (leftSize > rightSize + 1) {
            int value = left.lastKey();

            removeFromMap(left, value);
            leftSize--;

            addToMap(right, value);
            rightSize++;
        }

        while (leftSize < rightSize) {
            int value = right.firstKey();

            removeFromMap(right, value);
            rightSize--;

            addToMap(left, value);
            leftSize++;
        }
    }

    private double getMedian(int k) {
        if (k % 2 == 1) {
            return left.lastKey();
        }

        // int 덧셈 overflow를 피하기 위해 더하기 전에 double로 변환한다.
        return ((double) left.lastKey() + right.firstKey()) / 2.0;
    }

    private void addToMap(TreeMap<Integer, Integer> map, int value) {
        map.put(value, map.getOrDefault(value, 0) + 1);
    }

    private void removeFromMap(TreeMap<Integer, Integer> map, int value) {
        int count = map.get(value);

        if (count == 1) {
            map.remove(value);
        } else {
            map.put(value, count - 1);
        }
    }
}