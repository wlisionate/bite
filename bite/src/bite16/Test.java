package bite16;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/4/6 17:56
 * @Description:
 */
public class Test {
    private int nThread;
    private List<Thread> threads;
    private BlockingQueue<Runnable> workQueue;
    private static class Worker extends Thread{
        private BlockingQueue<Runnable> workQueue;
        Worker(BlockingQueue<Runnable> workQueue){
            this.workQueue = workQueue;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    Runnable target = workQueue.take();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    Test(int nThread){
        this.nThread = nThread;
        workQueue = new LinkedBlockingQueue<>();
        threads = new ArrayList<>();
        for(int i = 0;i<nThread;i++){
            Thread thread = new Worker(workQueue);
            thread.start();
            threads.add(thread);
        }
    }
    void execute(Runnable target) throws InterruptedException {
        workQueue.put(target);
    }
}
