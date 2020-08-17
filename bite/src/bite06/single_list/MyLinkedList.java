package bite06.single_list;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/1/11 16:00
 * @Description:
 */
public class MyLinkedList {
    private Node head;
    private int size;
    public MyLinkedList(){
        head = null;
        size = 0;
    }
    //头插
    public void pushFront(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;
        size++;
    }
    //头删
    public void popFront(){
        if (head == null){
            throw new RuntimeException("空了");
        }
        head = head.next;
    }
    //尾插
    public void pushBack(int val){
        Node node = new Node(val);
        if(head == null){
            head = node;
        }else {
            Node cur = head;
            while (cur.next != null){
                cur = cur.next;
            }
            cur.next = node;
        }
        size++;
    }
    //进行尾插优化操作
        public void pushBAck(int val){
            Node node = new Node(val);
            Node last = head;
            if(head == null){
                head = node;
            }else {
                last.next = node;
            }
            last = node;
            size++;
        }
    //尾删
    public void popBack(){
        if(head.next == null){
            head = null;
        }else {
            //找到倒数第二个结点
            Node cur = head;
            while (cur.next.next!= null){
                cur = cur.next;
            }
            cur.next = null;
        }
        size--;
    }
    //尾删优化操作

}
