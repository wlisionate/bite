package bite16.线程池;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MyThreadPool {
    private int nThreads;   // 记录允许创建的最大线程数
    private List<Thread> threads;               // 工作线程
    private BlockingQueue<Runnable> workQueue;  // 任务阻塞队列

    private static class Worker extends Thread {
        private BlockingQueue<Runnable> workQueue;

        Worker(BlockingQueue<Runnable> workQueue) {
            this.workQueue = workQueue;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    Runnable target = workQueue.take();
                    target.run();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    MyThreadPool(int nThreads) {
        this.nThreads = nThreads;

        // 创建阻塞队列
        workQueue = new LinkedBlockingQueue<>();    // 所有线程共享同一个阻塞队列对象

        // 提交创建线程
        threads = new ArrayList<>();
        for (int i = 0; i < nThreads; i++) {
            Thread thread = new Worker(workQueue);
            threads.add(thread);
        }
    }

    void execute(Runnable target) throws InterruptedException {
        workQueue.put(target);
    }
}
