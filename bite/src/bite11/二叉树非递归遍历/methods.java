package bite11.二叉树非递归遍历;

import sun.reflect.generics.tree.Tree;

import java.util.Stack;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/2/25 19:10
 * @Description:
 */
public class methods {
    //先序递归求解代码
    public static void preOr(TreeNode root){
        if(root != null){
            System.out.print(root.val+" ");
            preOr(root.left);
            preOr(root.right);
        }
    }
    //先序非递归求解代码
    public static void preOrFei(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = root;
        while (root != null || !stack.isEmpty()){
            while (pre != null){
                System.out.print(pre.val+" ");
                stack.push(pre);
                pre = pre.left;
            }
            pre = stack.pop();
            pre = pre.right;
        }
    }
    //中序的非递归遍历
    public static void midOrFei(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = root;
        while (pre != null || !stack.empty()){
            while (pre != null){
                stack.push(pre);
                pre = pre.left;
            }
            pre = stack.pop();
            System.out.print(pre.val+" ");
            pre = pre.right;
        }
    }
    //后序递归遍历
    public  static void houOr(TreeNode root){
        if(root != null){
            houOr(root.left);
            houOr(root.right);
            System.out.print(root.val+" ");
        }
    }
    //后序的非递归遍历
    public static void houOrFei(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;
        TreeNode prev = null;
        while (curNode != null|| !stack.empty()){
            while (curNode != null){
                //左子树
                stack.push(curNode);
                curNode = curNode.left;
            }
            //访问完右子树之后才能访问根
            //这里用pop有可能访问不到
            curNode = stack.peek();
            //判断右子树是否已经访问完
            //1.没有右子树
            //2.右子树访问完
            if(curNode.right == null || curNode.right == prev){
                System.out.print(curNode.val+" ");
                prev = curNode;
                stack.pop();
                curNode = null;
            }else {
                //右子树
                curNode = curNode.right;
            }
        }
    }
    public static TreeNode createTree(){
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        root1.left = root2;
        root1.right = root3;
        root2.left = root4;
        root2.right = root5;
        return root1;
    }

    public static void main(String[] args) {
        TreeNode root = createTree();
       // midOrFei(root);
        //houOr(root);
        preOrFei(root);
        System.out.println();
        //houOrFei(root);
    }
}
