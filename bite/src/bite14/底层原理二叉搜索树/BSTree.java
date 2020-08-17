package bite14.底层原理二叉搜索树;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/3/16 14:09
 * @Description:
 */
public class BSTree {
    //定义结点的静态内部类
    public static class Node{
        int value;
        Node left;
        Node right;
        public Node(int value){
            this.value = value;
            left = right = null;
        }
    }
    private Node root = null;
    //进行查找操作
    public Node find(int value){
        if(root == null)
            return null;
        Node cur = root;
        while (cur != null){
            if (cur.value>value)
                cur = cur.left;
            else if(cur.value<value)
                cur = cur.right;
            else
                return cur;
        }
        return null;
    }
    //进行插入操作
    public boolean insert(int value){
        if (root == null) {
            root = new Node(value);
            return true;
        }
        Node cur = root;
        Node parent = null;
        while (cur != null){
            parent = cur;
            if(cur.value == value)
                return false;
            else if (cur.value<value)
                cur = cur.right;
            else if (cur.value>value)
                cur = cur.left;
        }
        cur = new Node(value);
        if(parent.value>cur.value)
            parent.left = cur;
        else
            parent.right = cur;
        return true;
    }
    //进行中序遍历
    public void inOrder(){
        inOrderInternal(root);
        System.out.println();
    }

    private void inOrderInternal(Node root) {
        if(root != null){
            inOrderInternal(root.left);
            System.out.print(root.value+" ");
            inOrderInternal(root.right);
        }
    }
    //进行删除操作
    public boolean remove(int value){
        if (root == null)
            return false;
        Node cur = root;
        Node parent = null;
        while (cur != null){
            if(cur.value == value)
                break;
            else if(cur.value>value){
                parent = cur;
                cur = cur.left;
            }else {
                parent = cur;
                cur = cur.right;
            }
        }
        if(cur == null)
            return false;
        remove(parent,cur);
        return true;
    }
    public void remove(Node parent,Node cur){
        if(cur.left == null){
            if(cur!=root){
                if(parent.left == cur){
                    parent.left = cur.right;
                }else
                    parent.right = cur.right;
            }else
                root = cur.right;
        }else if(cur.right == null){
            if(cur!=root){
                if(parent.left == cur){
                    parent.left = cur.left;
                }else
                    parent.right = cur.left;
            }else
                root = cur.left;
        }else {
            parent = cur;
            Node next = cur.left;
            while (next.right != null){
                parent = next;
                next = next.right;
            }
            cur.value = next.value;
            if(parent.left == next)
                parent.left = next.left;
            else
                parent.right = next.left;
        }
    }
}
class Test{
    public static void main(String[] args) {
        BSTree bst = new BSTree();
        bst.insert(10);
        bst.insert(1);
        bst.insert(0);
        bst.insert(15);
        bst.insert(2);
        bst.insert(4);
        bst.insert(7);

        bst.inOrder();
        System.out.println(bst.find(7).value);
        bst.remove(7);
        bst.inOrder();

        bst.remove(2);
        bst.inOrder();

        bst.remove(10);
        bst.inOrder();

    }
}
