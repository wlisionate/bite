package bite09.单链表实现队列;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/1/14 15:53
 * @Description:
 */
class Node{
    int value;
    Node next;
}
public class Queue {
    Node front;
    Node rear;
    int size;
    public Queue(){
        front = rear = null;
        size = 0;
    }
    public void offer(int value){
        Node node = new Node();
        node.value = value;
        node.next = null;
        //一个结点也没有
        if(front == null){
            front = rear = node;
        }else {
            rear.next = node;
            rear = node;
        }
        size++;
    }
    public void poll(){
        if(front == null)
            return;
        front = front.next;
        //处理最后一个结点
        if(front == null)
            rear = null;
        size--;
    }
    public int peek(){
        if(front == null)
            return -1;
        return front.value;
    }
    public int rear(){
        if(front == null)
            return -1;
        return rear.value;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        System.out.println(queue.isEmpty());
        System.out.println(queue.size());
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        System.out.println(queue.isEmpty());
        System.out.println(queue.size());
        while (!queue.isEmpty()){
            System.out.println(queue.peek());
            queue.poll();
        }
        System.out.println(queue.isEmpty());
        System.out.println(queue.size());
    }
}
