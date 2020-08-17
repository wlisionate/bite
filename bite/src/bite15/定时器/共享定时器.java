package bite15.定时器;

import java.util.Timer;
//import java.util.TimerTask;

public class 共享定时器 {
    private static MyTimer timer = new MyTimer();

    private static class MyThread extends Thread {
        @Override
        public void run() {
            timer.schedule(new MyTimer.MyTimerTask() {
                @Override
                public void run() {
                    System.out.println("随便什么");
                }
            }, 10 * 1000);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new MyThread().start();
        }
    }
}
