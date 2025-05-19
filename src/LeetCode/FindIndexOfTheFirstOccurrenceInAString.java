package LeetCode;

public class FindIndexOfTheFirstOccurrenceInAString {
    public static void main(String[] args) {
        String haystack = "sadbutsad", needle = "sad";
        System.out.println(strStr(haystack, needle));
    }
    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
