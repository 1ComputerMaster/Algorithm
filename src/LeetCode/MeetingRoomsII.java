package LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * LeetCode 253. Meeting Rooms II
 *
 * <p><b>문제 설명</b></p>
 *
 * <p>
 * 여러 회의의 시작 시간과 종료 시간이 {@code intervals} 배열로 주어진다.
 * 각 {@code intervals[i] = [start, end]}는 하나의 회의가
 * {@code start} 시각에 시작하여 {@code end} 시각에 종료된다는 의미이다.
 * </p>
 *
 * <p>
 * 같은 시간에 진행되는 회의들은 서로 다른 회의실을 사용해야 한다.
 * 모든 회의를 진행하기 위해 필요한 최소 회의실 개수를 반환하라.
 * </p>
 *
 * <p>
 * 한 회의가 끝나는 시각과 다른 회의가 시작하는 시각이 같다면
 * 두 회의는 같은 회의실을 사용할 수 있다.
 * 예를 들어 {@code [2, 5]}와 {@code [5, 8]}은 하나의 회의실로 진행할 수 있다.
 * </p>
 *
 * <p><b>예제 1</b></p>
 * <pre>
 * 입력: intervals = [[0, 30], [5, 10], [15, 20]]
 * 출력: 2
 * 설명: [0, 30] 회의가 진행되는 동안 다른 회의가 겹치므로
 *       최소 2개의 회의실이 필요하다.
 * </pre>
 *
 * <p><b>예제 2</b></p>
 * <pre>
 * 입력: intervals = [[7, 10], [2, 4]]
 * 출력: 1
 * 설명: 두 회의 시간이 겹치지 않으므로 하나의 회의실이면 충분하다.
 * </pre>
 */
public class MeetingRoomsII {

    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        //endTime 기준으로 정렬을 우선 하자
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        //{2, 7}, {1, 10}, {8, 12}, {3, 19}, {10, 20}, {11, 30}
        for (int[] interval : intervals) {
            if (!minHeap.isEmpty() && interval[0] >= minHeap.peek()) {
                minHeap.poll();
            }
            minHeap.offer(interval[1]);

        }
        return minHeap.size();
    }

    public static void main(String[] args) {
        MeetingRoomsII solution = new MeetingRoomsII();

        run("겹치는 회의", () -> {
            int[][] intervals = {
                    {0, 30},
                    {5, 10},
                    {15, 20}
            };
            equal(2, solution.minMeetingRooms(intervals));
        });

        run("겹치지 않는 회의", () -> {
            int[][] intervals = {
                    {7, 10},
                    {2, 4}
            };
            equal(1, solution.minMeetingRooms(intervals));
        });

        run("종료와 시작 시간이 같은 회의", () -> {
            int[][] intervals = {
                    {1, 5},
                    {5, 10},
                    {10, 15}
            };
            equal(1, solution.minMeetingRooms(intervals));
        });

        run("여러 회의가 동시에 겹치는 경우", () -> {
            int[][] intervals = {
                    {1, 10},
                    {2, 8},
                    {3, 7},
                    {4, 6}
            };
            equal(4, solution.minMeetingRooms(intervals));
        });

        run("여러 회의가 겹치면서 다시 방을 재사용 할 수 있는 경우", () -> {
            int[][] intervals = {
                    {1, 10}, {2, 7}, {3, 19},
                    {8, 12}, {10, 20}, {11, 30}
            };
            equal(4, solution.minMeetingRooms(intervals));
        });
    }

    private static void run(String name, Runnable test) {
        try {
            test.run();
            System.out.println("[PASS] " + name);
        } catch (Throwable error) {
            System.out.println("[FAIL] " + name);
            System.out.println("       " + error);
            throw error;
        }
    }

    private static void equal(int expected, int actual) {
        if (expected != actual) {
            throw new AssertionError("expected=" + expected + ", actual=" + actual);
        }
    }
}
