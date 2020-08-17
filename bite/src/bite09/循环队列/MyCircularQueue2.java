package bite09.循环队列;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/1/14 20:54
 * @Description:
 */
public class MyCircularQueue2 {
    private  int[] list;
    int size,front,tail;
    public MyCircularQueue2(int k){
        size = k+1;
        list = new int[k+1];
    }
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isFull())
            return false;
        list[tail] = value;
        tail = (tail+1)%size;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty())
            return false;
        front++;
        front = front%size;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty())
            return -1;
        return list[front];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty())
            return -1;
        return list[(tail-1+size)%size];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return front == tail;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (tail+1)%list.length == front;
    }
}
