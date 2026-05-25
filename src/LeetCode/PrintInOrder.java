package LeetCode;

import java.util.concurrent.CountDownLatch;

public class PrintInOrder {
    public static void main(String[] args) {

    }
    private CountDownLatch firstDone;
    private CountDownLatch secondDone;


    public PrintInOrder() {
        firstDone = new CountDownLatch(1);
        secondDone = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstDone.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        firstDone.await();
        printSecond.run();
        secondDone.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        secondDone.await();
        printThird.run();
    }
}
