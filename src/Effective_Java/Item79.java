package Effective_Java;

import java.util.HashSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Item79 {

    @FunctionalInterface
    public interface SetObserver<E> {
        // ObservableSet에 원소가 추가되면 호출된다.
        void added(ObservableSet<E> set, E element);
    }

    public static void main(String[] args) {
    ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());
    set.addObserver(new SetObserver<>() {
        public void added(ObservableSet<Integer> s, Integer e) {
            System.out.println(e);
            if (e == 23) {
                ExecutorService exec = Executors.newSingleThreadExecutor();
                try {
                    // 여기서 lock이 발생한다. (메인 스레드는 작업을 기리고 있음)
                    // 특정 태스크가 완료되기를 기다린다. (submit의 get 메서드)
                    exec.submit(() -> s.removeObserver(this)).get();
                } catch (ExecutionException | InterruptedException ex) {
                    throw new AssertionError(ex);
                } finally {
                    exec.shutdown();
                }
            }
        }
    });
    
    for (int i = 0; i < 100; i++)
        set.add(i);
    }
}
