package bite10.多线程;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/1/15 15:27
 * @Description:
 */
public class HowThreadDie {
    private static class Worker extends Thread{
        private volatile static boolean running = true;
        public void quit(){
            running = false;
//            System.out.println("收到");
}
        @Override
        public void run() {
            while (running){
                System.out.println("挖煤");
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();
        worker.start();
        Thread.sleep(10*1000);
        System.out.println("媳妇要生了，赶紧回家");
        worker.quit();
        worker.join();
        System.out.println("结束本次表演");
    }
}
