package bite10.多线程;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/1/15 10:57
 * @Description:
 */
public class Secene1 {
    private static final long COUNT = 100_0000_0000L;
    private static class MyThread extends Thread{
        @Override
        public void run() {
            long b= 0;
            for(long i = 0;i<COUNT;i++){
                b+=i;
            }
        }
    }
    private static void multithread() throws InterruptedException {
        long begin = System.currentTimeMillis();
        MyThread thread = new MyThread();
        thread.start();
        long b= 0;
        for(long i = 0;i<COUNT;i++){
            b+=i;
        }
        thread.join();//是主线程等待子线程的终止。也就是在子线程调用了join()方法后面的代码，只有等到子线程结束了才能执行。(Waits for this thread to die.)
        long end = System.currentTimeMillis();
        System.out.println(end-begin);
    }
    private static void mult(){
        long begin = System.currentTimeMillis();
        long b= 0;
        for(long i = 0;i<COUNT;i++){
            b+=i;
        }
        long a= 0;
        for(long i = 0;i<COUNT;i++){
            a+=i;
        }
        long end = System.currentTimeMillis();
        System.out.println(end-begin);
    }

    public static void main(String[] args) throws InterruptedException {
        multithread();
        mult();
    }
}
