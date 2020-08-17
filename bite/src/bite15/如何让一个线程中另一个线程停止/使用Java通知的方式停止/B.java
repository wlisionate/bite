package bite15.如何让一个线程中另一个线程停止.使用Java通知的方式停止;

public class B extends Thread {
    @Override
    public void run() {
        // B 线程中判断是否有人让自己停止
        while (Thread.interrupted() == false) {
            System.out.println("挖煤");
        }
    }
}
