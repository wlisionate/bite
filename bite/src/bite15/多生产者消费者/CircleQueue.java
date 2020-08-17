package bite15.多生产者消费者;

// 队列中的元素类型是 int
public class CircleQueue {
    private static final int CAPACITY = 2;

    private int[] queue = new int[CAPACITY];
    private int size = 0;
    private int frontIndex = 0;
    private int rearIndex = 0;

    // 放入队列
    public synchronized void put(int element) throws InterruptedException {
        // 判断队列是否已满
        while (size == queue.length) {
            //throw new RuntimeException("队列已满");
            // 让线程阻塞
            // 让线程阻塞，并且很方便让另外的线程把它唤醒
            wait(); // 生产者阻塞，等待消费者唤醒
        }

        // 队列中还有空间
        queue[rearIndex] = element;
        rearIndex = rearIndex + 1;
        if (rearIndex == queue.length) {
            rearIndex = 0;
        }

        // 是可以交换的，wait() 被唤醒是不是需要去抢锁？ YES
        // 问，notify 把消费者唤醒后，我生产者把锁释放了么？ NO
        // 我把消费者唤醒，消费者也无法执行，需要在等我把锁释放
        size++;
        System.out.println(size);
        notifyAll();   // 生产者试图唤醒阻塞的消费者

    }   // 释放完锁，消费者才可以执行

    // 从队列中取
    public synchronized int take() throws InterruptedException {
        // 判断队列是否为空
        while (size == 0) {
            // wait();
            this.wait(); // 消费者阻塞，等待生产者唤醒
            //throw new RuntimeException("队列为空");
        }

        // 队列不为空
        int element = queue[frontIndex];
        frontIndex += 1;
        if (frontIndex == queue.length) {
            frontIndex = 0;
        }

        size--;
        System.out.println(size);
        // 消费者消费掉一个元素，队列一定不满了
        // 尝试唤醒一个生产者了
        this.notifyAll();   // 试图唤醒等待的生产者

        return element;
    }
}
