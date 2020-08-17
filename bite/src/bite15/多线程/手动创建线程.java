package bite15.多线程;

public class 手动创建线程 {

    static class MyThread extends Thread {
        @Override
        public void run() {
        }
    }
/*
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        // t1 和 t2 这两个引用指向了各自的线程对象
        // 线程最终要执行是 run 方法中的代码
    }
    */

    /*static class MyRunnable implements Runnable {
        @Override
        public void run() {
        }
    }

    public static void main(String[] args) {
        MyRunnable mr1 = new MyRunnable();
        MyRunnable mr2 = new MyRunnable();
        // mr1 和 mr2 引用指向各自的 任务对象

        // 最终线程需要有线程对象
        Thread t1 = new Thread(mr1);    // mr1 指向的任务作为 t1 线程的任务
        Thread t2 = new Thread(mr1);    // mr1 指向的任务作为 t2 线程的任务
        Thread t3 = new Thread(mr2);    // mr2 指向的任务作为 t3 线程的任务
    }
    */
}
