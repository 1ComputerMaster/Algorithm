package LeetCode;

public class PartitionLabels {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(s)); // Should return [9,7,8]
    }
    public static java.util.List<Integer> partitionLabels(String s) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        int[] lastIndex = new int[26];

        // 각 문자의 마지막 인덱스 기록
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            //이미 현재 문자 보다 더 늦게 들어오는 값 중에 더 뒤의 값들은 end를 갱신 하기 때문에 내 위치로 부터의 최고 점 이후를 찾을 수 있다.
            end = Math.max(end, lastIndex[s.charAt(i) - 'a']);
            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }

        return result;
    }
}
