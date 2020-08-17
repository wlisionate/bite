package bite15.多生产者消费者;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class 单生产者单消费者 {
    private static CircleQueue queue = new CircleQueue();

    private static class 生产者 extends Thread {
        生产者() {
            super("生产者");
        }

        @Override
        public void run() {
            Scanner scanner = new Scanner(System.in);
            try {
                while (true) {
                    System.out.print("请输入下一个数字: ");
                    int element = scanner.nextInt();
                    queue.put(element); // 如果队列不满，直接放入
                                        // 如果队列满了，阻塞
                                        // 消费者会唤醒
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
            Random random = new Random(20200405);
            try {
                while (true) {
                    int element = queue.take(); // 如果队列为空，则阻塞
                    System.out.println("消费者读出: " + element);
                    // 等待随机秒，最多 10 s
                    TimeUnit.SECONDS.sleep(random.nextInt(10));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        生产者 p = new 生产者();
        p.start();
        消费者 c = new 消费者();
        c.start();
    }
}
