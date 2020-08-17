package bite10.多线程;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/1/15 14:07
 * @Description:
 */
public class longDemo {
    private static long COUNT = 100000000L;
    public static class MyThread extends Thread{
        @Override
        public void run() {
            long num = 0;
            for(long i = 1;i<COUNT;i++){
                num+=i*i;
            }
            System.out.println("来自方法1 "+num);
        }
    }
    public static class MyRunnable implements Runnable{

        @Override
        public void run() {
            long num = 0;
            for(long i = 1;i<COUNT;i++){
                num+=i*i;
            }
            System.out.println("来自方法2 "+num);
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
        Thread thread1 = new Thread(myThread);
        thread1.start();
    }
}
