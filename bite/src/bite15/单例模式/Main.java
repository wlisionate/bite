package bite15.单例模式;

public class Main {
    private static class SubThread extends Thread {
        @Override
        public void run() {
            Starving starving = Starving.getInstance();
            // 每个线程中拿到的 starving 是否是同一个对象
            // 并且完整无误
        }
    }
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new SubThread().start();
        }
    }
}
