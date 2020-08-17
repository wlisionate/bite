package bite15.多生产者消费者;

import java.util.Random;

public class 多生产者多消费者 {
    private static CircleQueue queue = new CircleQueue();

    private static class 生产者 extends Thread {
        生产者() {
            super("生产者");
        }

        @Override
        public void run() {
            Random random = new Random(20200405);
            try {
                while (true) {
                    queue.put(random.nextInt(200));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class 消费者 extends Thread {
        消费者() {
            super("消费者");
        }

        @Override
        public void run() {
            try {
                while (true) {
                    queue.take();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new 生产者().start();
        }

        for (int i = 0; i < 10; i++) {
            new 消费者().start();
        }
    }
}
