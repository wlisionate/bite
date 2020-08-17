package leetcode;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2019/12/15 16:47
 * @Description:
 */
public class ListNode {
    int val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
        this.next = null;
    }
    public void addFirst(ListNode head){
        int data = 0;
        ListNode listNode = new ListNode(data);
        listNode.next = head;
        head = listNode;
    }
    public void addLast(ListNode head){
        int data = 0;
        ListNode listNode = new ListNode(data);
        head.next = listNode;
        listNode.next = null;
    }
    public void create(){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(1);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
    }
    public static void main(String[] args) {

    }
}
