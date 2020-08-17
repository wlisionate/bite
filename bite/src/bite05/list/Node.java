package bite05.list;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/1/8 14:50
 * @Description:
 */
public class Node {
    int val;
    Node next;
    public Node(int val,Node next){
        this.next = next;
        this.val = val;
    }
    public Node(int val){
        this(val,null);
    }
    @Override
    public String toString(){
        return String.format("Node{%d}",val);
    }
}
