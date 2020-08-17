package bite05.list;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/1/8 14:52
 * @Description:
 */
public class MyLinkList {
    public static Node buildLinkedListHand(){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        return n1;
    }
    public static void printNode(Node head){
        Node cur = head;
        while (cur != null){
            System.out.println(cur);
            cur = cur.next;
        }
    }
    //实现头插
    public static Node pushFront(Node head,int val){
        Node node = new Node(val);
        node.next  = head;
        head = node;
        return head;
    }
    //实现头删
    public static Node popFront(Node head){
        if(head == null){
            throw new RuntimeException("空链表");
        }
        head = head.next;
        return head;
    }
    //尾插（分情况讨论）
    public static Node pushBack(Node head,int val) {
        Node node = new Node(val);
        //当链表中没有结点的时候
        if (head == null) {
            return node;
        } else {
            //当链表中至少有一个结点
            Node cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
            return head;
        }
    }
    //进行尾部删除操作
    public static Node popBack(Node head){
        if(head == null){
            throw new RuntimeException("空的");
        }
        if(head.next == null){
            return null;
        }else {
            Node cur = head;
            while (cur.next.next != null) {
                cur = cur.next;
            }
            cur.next = null;
            return head;
        }
    }
    //打印到倒数第n个结点
    public static void printPartList(Node head){
        Node cur;
        //找到第三个结点
        cur = head;
        for(int i=0;i<2;i++){
            cur = cur.next;
        }
        for(Node n = cur;n != null;n = n.next){
            System.out.println(n.val);
        }
        //找到第三个结点
        //找到倒数第三个节点
        cur = head;
        for(int i=0;i<2;i++){
            cur = cur.next;
        }
        for(Node n = cur;n.next.next!=null;n = n.next){
            System.out.println(n.val);
        }
    }
    public static void main(String[] args) {
        //Node head = buildLinkedListHand();
//        printNode(head);
        //测试进行头插
//        Node head = null;
//        head = pushFront(head,0);
//        head = pushFront(head,1);
//        head = pushFront(head,2);
//        head = pushFront(head,3);
//        head = pushFront(head,4);
//        printNode(head);
//        //进行头删测试
//        head = popFront(head);
//        printNode(head);
        //测试选取固定区域结点
//        printPartList(head);
        Node head = null;
        head = pushBack(head,1);
        head = pushBack(head,2);
        head = pushBack(head,3);
        head = pushBack(head,4);
        head = pushBack(head,5);
        printNode(head);
        head = popBack(head);
        head = popBack(head);
        head = popBack(head);
        head = popBack(head);
        printNode(head);
        head = popBack(head);
        head = popBack(head);
        printNode(head);
    }
}
