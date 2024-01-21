package Effective_Java;

import java.util.ArrayList;
import java.util.List;

public class SubListExample {
    public static <T> List<List<T>> getSubLists(List<T> list) {
        List<List<T>> subLists = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j <= list.size(); j++) {
                subLists.add(list.subList(i, j));
            }
        }
        return subLists;
    }
    
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        List<List<Integer>> subLists = getSubLists(list);
        for (List<Integer> subList : subLists) {
            System.out.println(subList);
        }
    }
}
