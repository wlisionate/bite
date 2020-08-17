package bite07.interfaceTest;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/1/12 14:37
 * @Description:
 */
public class MyLinkedList implements MyList {
    Node head = null;
    @Override
    public void popFront() {
        head = head.next;
    }

    @Override
    public void pushFront(int elem) {
        Node node = new Node(elem);
        node.next = head;
        head = node;
    }

    public static void main(String[] args) {

    }
}
