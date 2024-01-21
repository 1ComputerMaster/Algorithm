// package Effective_Java;

// import java.util.HashSet;
// import java.util.concurrent.ExecutionException;
// import java.util.concurrent.ExecutorService;
// import java.util.concurrent.Executors;

// public class Item79_1 {

//     @FunctionalInterface
//     public interface SetObserver<E> {
//         // ObservableSet에 원소가 추가되면 호출된다.
//         void added(ObservableSet<E> set, E element);
//     }

//    public static void main(String[] args) {
//     ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());
    
//     set.addObserver(new SetObserver<>(){
//         public void added(ObservableSet<Integer> s, Integer e) {
//             System.out.println(e);
//             if (e == 23)
//                 s.removeObserver(this);
//         }

//     });
    

//     }

// }
