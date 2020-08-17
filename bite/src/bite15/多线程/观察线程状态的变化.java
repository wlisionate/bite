package bite15.多线程;

import java.util.concurrent.TimeUnit;

public class 观察线程状态的变化 {
    private static class AThread extends Thread {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 3; i++) {
                    System.out.println("工作中");
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (InterruptedException e) {}
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AThread a = new AThread();
        System.out.println(a.getState());   // NEW
        a.start();
        System.out.println(a.getState());   // RUNNABLE
        TimeUnit.SECONDS.sleep(2);
        System.out.println(a.getState());   // TIMED_WAITING // 因为刚好 a 线程在执行 sleep
        TimeUnit.SECONDS.sleep(2);
        System.out.println(a.getState());   // TERMINATED
    }
}
