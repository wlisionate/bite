package bite15;

public class AddSub {
    // 问题的核心是原子性的问题，所以 volatile 这里解决不了原子性
    private static long n = 0;
    private static final long COUNT = 1_0000_0000L;

    private static class Add extends Thread {
        private Object lock;

        Add(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            for (long i = 0; i < COUNT; i++) {
                synchronized (lock) {
                    n++;
                }
            }
        }
    }
    private static class Sub extends Thread {
        private Object lock;
        Sub(Object lock) {
            this.lock = lock;
        }
        @Override
        public void run() {
            for (long i = 0; i < COUNT; i++) {
                synchronized (lock) {
                    n--;
                }
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        //Object lock = new Object();
        AddSub lock = new AddSub();
        Add add = new Add(lock);
        Sub sub = new Sub(lock);
        add.start();
        sub.start();

        add.join();
        sub.join();
        System.out.println(n);
    }
}
