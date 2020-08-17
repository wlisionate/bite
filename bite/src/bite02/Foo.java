package bite02;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2019/12/12 11:56
 * @Description:
 */
public class Foo {
    boolean first;
    boolean second;
    Object lock = new Object();
    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (lock) {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            first = true;
            lock.notifyAll();//唤醒所有线程
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock) {
            while (!first){
                lock.wait();//进行锁的释放
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            second = true;
            lock.notifyAll();//唤醒所有线程
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock) {
            while (!second){
                lock.wait();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}
