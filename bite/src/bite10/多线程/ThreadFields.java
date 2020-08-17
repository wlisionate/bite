package bite10.多线程;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/1/15 14:47
 * @Description:
 */
public class ThreadFields {
    public static void main(String[] args) {
        //获取当前线程的Thread对象
        //Thread.currentThread()
//        Thread currentThread = Thread.currentThread();
//        System.out.println(currentThread.getId());
//        System.out.println(currentThread.getName());
//        System.out.println(currentThread.getPriority());
//        System.out.println(currentThread.getState());
//        System.out.println(currentThread.isAlive());
//        System.out.println(currentThread.isDaemon());
//        System.out.println(currentThread.isInterrupted());
        Thread t = new Thread() {
            @Override
            public void run() {
                dianping();
            }
        };
        t.run();
        System.out.println("dazhong");
    }
    static void dianping(){
        System.out.println("dianping");
    }

}
