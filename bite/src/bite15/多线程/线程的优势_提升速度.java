package bite15.多线程;

public class 线程的优势_提升速度 {
    private static final   long COUNT = 10_0000_0000L;
    private static final  int N = 10;                // 一共计算 10 次

    private static void calc() {
        long r = 0;

        for (long i = 0; i < COUNT; i++) {
            r += i;
        }

        System.out.println(r);
    }

    private static class CalcThread extends Thread {
        @Override
        public void run() {
            // 一个线程只需要计算一遍 calc
            calc();
        }
    }

    // 主线程一个线程在计算
    public static void main(String[] args) throws InterruptedException {
        long start = System.nanoTime();

        CalcThread[] threads = new CalcThread[N - 1];
        // N 个线程同时执行，其实主线程不需要我创建，所以我需要创建 N - 1 个线程
        for (int i = 0; i < N - 1; i++) {
            // 创建了 N - 1 个线程，每个线程都执行一次
            CalcThread thread = new CalcThread();
            thread.start();
            threads[i] = thread;
        }

        calc(); // 剩余的一次，放到主线程中来计算

        // 什么时候记录结束时间？
        // 代码走到的这里时，只代表主线程中的 calc 计算完了，但
        // 另外的 N - 1 个线程是否计算完成，是不知道的
        // 所以，我需要等另外 N - 1 个线程全部完成，才结束计时
        for (int i = 0; i < N - 1; i++) {
            threads[i].join(); // 阻塞在这个方法上，直到 threads[i] 线程执行结束
        }

        // 这时代表所有的线程都执行结束了
        long end = System.nanoTime();
        double 耗时ms = (end - start) * 1.0 / 1000 / 1000;
        System.out.println("耗时: " + 耗时ms);

        /*
        long start = System.nanoTime();
        for (int i = 0; i < N; i++) {
            calc();
        }
        long end = System.nanoTime();
        double 耗时ms = (end - start) * 1.0 / 1000 / 1000;
        System.out.println("耗时: " + 耗时ms);
        */
    }
}
