package Effective_Java;

import java.util.*;
import java.util.stream.*;

public class SubList {
    
    public static <E> Stream<List<E>> of(List<E> list) {
        return Stream.concat(Stream.of(Collections.emptyList()),
        prefixes(list).flatMap(SubList::suffixes));
    }
    
    public static <E> Stream<List<E>> prefixes(List<E> list) {
        return IntStream.rangeClosed(1, list.size())
            .mapToObj(end -> list.subList(0, end));
    }
    
    public static <E> Stream<List<E>> suffixes(List<E> list) {
        return IntStream.rangeClosed(0, list.size())
            .mapToObj(start -> list.subList(start, list.size()));
    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        SubList.of(list).forEach(System.out::println);
    }
}