package Effective_Java;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Item84 {

    public static void main(String args[]) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(100000);
        List<Thread> workers = Stream
                .generate(() -> new Thread(new Worker(countDownLatch)))
                .limit(100000)
                .collect(Collectors.toList());

        long startTime = System.currentTimeMillis();

        workers.forEach(Thread::start);

        countDownLatch.await();

        long endTime = System.currentTimeMillis();

        long executionTime = endTime - startTime;


        SlowCountDownLatch slowCountDownLatch = new SlowCountDownLatch(100000);
        List<Thread> workers2 = Stream
                .generate(() -> new Thread(new slowWorker(slowCountDownLatch)))
                .limit(100000)
                .collect(Collectors.toList());

        long startTime2 = System.currentTimeMillis();

        workers2.forEach(Thread::start);

        
        slowCountDownLatch.await();

        long endTime2 = System.currentTimeMillis();

        long executionTime2 = endTime2 - startTime2;

        System.out.println(" Java CountDownLatch " + executionTime +" mills"+ " slow down latch milliseconds : " + executionTime2 + " mills");

    }

    public static class Worker implements Runnable {
        private CountDownLatch countDownLatch;

        public Worker(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            countDownLatch.countDown();
        }
    }

    public static class slowWorker implements Runnable {
        private SlowCountDownLatch slowCountDownLatch;

        public slowWorker(SlowCountDownLatch slowCountDownLatch) {
            this.slowCountDownLatch = slowCountDownLatch;
        }

        @Override
        public void run() {
            slowCountDownLatch.countDown();
        }
    }

    public static class SlowCountDownLatch {
        private int count;
      
        public SlowCountDownLatch(int count) {
          if (count < 0)
            throw new IllegalArgumentException(count + " < 0");
          this.count = count;
        }
      
        public void await() {
          while (true) {
            synchronized(this) {
              if (count == 0)
                return;
            }
          }
        }
        public synchronized void countDown() {
          if (count != 0)
            count--;
        }
    }
}
