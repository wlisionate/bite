//package binaryTree;
//
//import javafx.concurrent.ScheduledService;
//
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
///**
// * ⊙﹏⊙&&&&&&⊙▽⊙
// *
// * @Auther: pangchenbo
// * @Date: 2019/12/12 19:40
// * @Description:
// */
//public class Tree {
//    //private Node root = null;
//    //进行先序遍历
//    public void preOrder(Node root){
//        if(root == null){
//            return;
//        }else {
//            System.out.println(root.val);
//            preOrder(root.left);
//            preOrder(root.right);
//        }
//    }
//    //进行中序遍历
//    public void inOrder(Node root){
//        if(root != null){
//            //访问左子树
//            inOrder(root.left);
//            //根
//            System.out.println(root.val);
//            //访问右子树
//            inOrder(root.right);
//        }
//    }
//    //进行后序遍历
//    public  void postOrder(Node root){
//        if(root != null){
//            //访问左子树
//            postOrder(root.left);
//            //访问右子树
//            postOrder(root.right);
//            //根
//            System.out.println(root.val);
//        }
//    }
//    //进行层序遍历
//    public void leverOrder(TreeNode root){
//        Queue<TreeNode> nodeQueue = new LinkedList<>();
//        if(root !=  null)
//        nodeQueue.offer(root);
//        while (!nodeQueue.isEmpty()){
//            //先取栈顶元素
//            TreeNode treeNode = nodeQueue.poll();
//            System.out.println(treeNode.val);
//            if(root.left != null)
//                nodeQueue.offer(root.left);
//            if(root.right != null)
//                nodeQueue.offer(root.right);
//        }
//    }
//    //判断是否为完全二叉树
//    public boolean isCompleteTree(TreeNode root) {
//        Queue<TreeNode> nodeQueue = new LinkedList<>();
//        if (root != null)
//            nodeQueue.offer(root);
//        //进行遍历，在null地方停下来。
//        while (!nodeQueue.isEmpty()){
//            TreeNode treeNode = nodeQueue.poll();
//            if(treeNode == null){
//                break;
//            }
//
//            nodeQueue.offer(root.left);
//            nodeQueue.offer(root.right);
//        }
//        //把剩余元素全部出队，如果后面全部是空，则是完全二叉树，如果后面出现一个值，则不是完全二叉树
//        while (!nodeQueue.isEmpty()){
//            TreeNode treeNode = nodeQueue.poll();
//            if(treeNode != null)
//                return false;
//        }
//        return true;
//    }
//    static int size = 0;
//    //获取数的结点的个数
//    public void getSize1(Node root){
//        if(root != null){
//            getSize1(root.left);
//            size++;
//            getSize1(root.right);
//        }
//    }
//    //求树的结点
//    //求解子问题的思路
//    public int  getSize2(Node root){
//        if(root == null)
//            return 0;
//        if(root.left == null && root.right == null)
//            return 1;
//        return getSize2(root.left)+getSize2(root.right)+1;//加一操作进行加自己操作
//    }
//    //求树的叶子节点
//    private static int leafSize;
//    public void getLeafSize1(Node root){
//        if(root == null){
//            return;
//        }
//        if(root.left == null && root.right == null){
//            leafSize++;
//            return;
//        }
//        getLeafSize1(root.left);
//        getLeafSize1(root.right);
//    }
//    //求树的叶子节点
//    //求解子问题的思路
//    public int getLeafSize2(Node root){
//        if(root == null)
//            return 0;
//        if(root.right == null && root.left == null)
//            return 1;
//        return getLeafSize2(root.left)+getLeafSize2(root.right);
//    }
//    //求第K层结点的个数
//    public int getKLevelSize(Node root,int k){
//        if(root == null){
//            return 0;
//        }
//        if(k == 1){
//            return 1;
//        }
//        return getKLevelSize(root.left,k-1)+getKLevelSize(root.right,k-1);
//    }
//    //查找某个节点
//    public Node find(Node root,String val){
//        if(root == null)
//            return root;//结束条件
//        if(root.val == val)
//            return root;
//        Node node = find(root.left,val);
//        if(node != null)
//            return node;
//        return find(root.right,val);
//    }
//    //进行建树操作
////    public Node buildTree(Node node){
////        Scanner scanner = new Scanner(System.in);
////        String s = scanner.next();
////        scanner.nextLine();
////        Node node1 = new Node(s);
////        if(node == null  ||node1.val == "#"){
////            return null;
////        }else {
////            buildTree(node.left);
////            buildTree(node.right);
////        }
////        return node;
////    }
//}
//class Node{
//    char value;
//    Node left;
//    Node right;
//    public Node(char value){
//        this.value = value;
//    }
//}
////牛客网
// class Main1{
//    private static int i;
//    public  static Node buildTree(String s){
//        if(s.charAt(i) != '#'){
//            Node root = new Node(s.charAt(i));
//            ++i;
//            root.left = buildTree(s);
//            ++i;
//            root.right = buildTree(s);
//            return root;
//        }
//        return null;
//    }
//    public static void inOrder(Node root){
//        if(root != null){
//            inOrder(root.left);
//            System.out.print(root.value+" ");
//            inOrder(root.right);
//        }
//    }
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String line = scanner.nextLine();
//        Node root = buildTree(line);
//        inOrder(root);
//        System.out.println();
//    }
//}
