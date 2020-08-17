package bite10;

import java.util.HashSet;
import java.util.Set;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/1/15 10:50
 * @Description:
 */
public class Test {
    private static class MyThread extends Thread{
        @Override
        public void run() {
            super.run();
        }
    }
    private static class MyThread1 implements Runnable{

        @Override
        public void run() {

        }
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
        MyThread1 myThread1 = new MyThread1();
        Thread thread1 = new Thread(myThread1);
        thread1.start();
//        System.out.println(thread1.getName());
        Thread thread2 = new Thread(thread);
        thread2.start();
    }
}
