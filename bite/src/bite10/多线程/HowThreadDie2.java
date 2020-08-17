package bite10.多线程;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/1/15 15:27
 * @Description:
 */
public class HowThreadDie2 {
    private static class Worker extends Thread{
        private volatile static boolean running = true;
        @Override
        public void run() {
            while (!Thread.interrupted()){
                System.out.println("挖煤");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();
        worker.start();
        Thread.sleep(100);
        System.out.println("媳妇要生了，赶紧回家");
        worker.interrupt();
        worker.join();
        System.out.println("结束本次表演");
    }
}
