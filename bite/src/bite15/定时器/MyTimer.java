package bite15.定时器;

public class MyTimer {
    static abstract class MyTimerTask {
        abstract void run();
    }

    void schedule(MyTimerTask task, long delay) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(delay);
                    task.run();
                } catch (InterruptedException e) {
                }
            }
        }).start();
    }
}
