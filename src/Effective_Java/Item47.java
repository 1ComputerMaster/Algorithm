package Effective_Java;
import java.util.*;
import java.util.stream.Stream;



public class Item47 {
    public static<E> Iterable<E> iterableOf(Stream<E> stream) {
        return stream::iterator;
    } 
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("Apple", "Banana", "Cherry");

        stream.forEach(s ->{
            System.out.println(s);
        });

        // Iterable<String> iterable = iterableOf(stream);
        
        // for (String element : iterable) {
        //     System.out.println(element);
        // }
    }
}
