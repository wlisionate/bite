//package binaryTree;
//
//import java.util.*;
//
///**
// * ⊙﹏⊙&&&&&&⊙▽⊙
// *
// * @Auther: pangchenbo
// * @Date: 2019/12/22 09:24
// * @Description:
// */
//public class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int val){
//        this.val = val;
//    }
//    List<Integer> list = new ArrayList<>();
//    List<Integer> list1 = new ArrayList<>();
//    public List<Integer> inorderTr(TreeNode root){
//        if(root != null){
//            inorderTr(root.left);
//            list.add(root.val);
//            inorderTr(root.right);
//        }else
//            return list1;
//        return list;
//    }
//    //判断最大深度
//    public int MaxDeapth(TreeNode root){
//        return root == null ? 0:Math.max(MaxDeapth(root.left),MaxDeapth(root.right))+1;
//    }
//    public int maxDepth(TreeNode root) {
//        int tempLeft = 0;
//        int tempRight = 0;
//        int max = 0;
//        if(root == null){
//            return 0;
//        }
//        tempLeft = maxDepth(root.left);
//
//        tempRight = maxDepth(root.right);
//        if(tempLeft>tempRight){
//            max = tempLeft+1;
//            return max;
//        }
//        max = tempRight+1;
//        return max;
//    }
//    //平衡二叉树
//    public boolean isBalanced(TreeNode root) {
//        if (root == null)
//            return true;
//        int left = MaxDeapth(root.left);
//        int right = MaxDeapth(root.right);
//        return Math.abs(left-right)<2 && isBalanced(root.left)&& isBalanced(root.right);
//    }
//    //对称二叉树
//    public boolean fun(TreeNode left,TreeNode right){
//        if(left== null && right == null)
//            return true;
//        if(left== null || right == null)
//            return false;
//        return left.val == right.val && fun(left.left,right.right)&&fun(left.right,right.left);
//    }
//    public boolean isSymmetric(TreeNode root) {
//        if(root == null)
//            return true;
//        return fun(root.left,root.right);
//
//    }
//    //判断相同的树
//    public boolean isSameTree(TreeNode a ,TreeNode b){
//        if(a==null && b==null)
//            return true;
//        if(a==null || b == null)
//            return false;
//        if(a.val == b.val){
//            return isSameTree(a.left,b.left) && isSameTree(a.right,b.right);
//        }
//        return false;
//    }
//    //判断是否是它的子树
//    public boolean isSonTree(TreeNode q,TreeNode p){
//        if(q==null && p==null)
//            return true;
//        if(q==null || p == null)
//            return false;
//        if(q.val == p.val){
//            return isSameTree(q,p)||isSonTree(q.left,p)||isSonTree(q.right,p);
//        }
//        return isSameTree(q.left,p) || isSameTree(q.right,p);
//    }
//    //二叉树的层序遍历
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> list = new ArrayList<>();
//        Queue<TreeNode> nodeQueue = new LinkedList<>();
//        if(root != null)
//            nodeQueue.offer(root);
//        while (!nodeQueue.isEmpty()){
//            int size = nodeQueue.size();
//            List<Integer> integerList = new ArrayList<>();
//            while (size>0){
//                TreeNode node = nodeQueue.poll();
//                integerList.add(node.val);
//                if(node.left != null)
//                    nodeQueue.offer(node.left);
//                if(node.right != null)
//                    nodeQueue.offer(node.right);
//                --size;
//            }
//            list.add(integerList);
//        }
//        return list;
//    }
//}
////二叉树的最近公共祖先查找
///**
// * 要点：判断这两个点是不是在他的左右子树上
// * 如果全部在左子树上，那就继续查找
// * 如果在它的左右子树上那就输出当前结点就是它的最近公共祖先
// * 如果当前结点有一个值是结点的值，那这个点就是它的公共祖先
// */
//class MyStack {
//    public boolean find(TreeNode root,TreeNode node){
//        if(root == null)
//            return false;
//        if(root == node)
//            return true;
//        if(find(root.left,node))
//            return true;
//        return find(root.right,node);
//    }
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        boolean pL=false,pR=false,qL=false,qR=false;
//        if(root == p||root == q){
//            return root;
//        }
//        if(find(root.left,p))
//            pL = true;
//        else pR=true;
//        if(find(root.left,q))
//            qL = true;
//        else qR = true;
//        if(qL && pL){
//            return lowestCommonAncestor(root.left,p,q);
//        }
//        else if(qR && pR){
//            return lowestCommonAncestor(root.right,p,q);
//        }
//        else return root;
//    }
//}
////寻找公共祖先
///*
//* 利用栈进行路径的保存，设置两个栈保存两个结点的路径，然后从栈顶开始判断两个路径第一个
//* 相同的点的值就是他们的最近公共祖先
//*
//* */
//class MyStack {
//    public boolean getPath(TreeNode root, TreeNode node, Stack<TreeNode> st){
//        if(root == null)
//            return false;
//        st.push(root);
//        if(root == node)
//            return true;
//        if(getPath(root.left,node,st))
//            return true;
//        if(getPath(root.right,node,st))
//            return true;
//        st.pop();
//        return false;
//    }
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        Stack<TreeNode> s1 = new Stack<>();
//        Stack<TreeNode> s2 = new Stack<>();
//        getPath(root,p,s1);
//        getPath(root,q,s2);
//        while (s1.size() != s2.size()){
//            if(s1.size()>s2.size()){
//                s1.pop();
//            }else {
//                s2.pop();
//            }
//        }
//        //进行匹配
//        while (s1.size() != 0){
//            if(s1.peek() == s2.peek())
//                break;
//            else{
//                s1.pop();
//                s2.pop();
//            }
//        }
//        return s1.peek();
//    }
//}
////将一个二叉搜索树转化为双向链表
///**
// public class TreeNode {
// int val = 0;
// TreeNode left = null;
// TreeNode right = null;
//
// public TreeNode(int val) {
// this.val = val;
//
// }
//
// }
// */
//public class MyStack {
//    static TreeNode prev =null;
//    public void _Convert(TreeNode root){
//        if(root == null)
//            return;
//        _Convert(root.left);
//        root.left = prev;
//        if(prev!= null)
//            prev.right = root;
//        prev = root;
//        _Convert(root.right);
//    }
//    public TreeNode Convert(TreeNode pRootOfTree) {
//        if(pRootOfTree == null)
//            return null;
//        prev = null;
//        _Convert(pRootOfTree);
//        //返回头，左边的最后一个非空结点
//        while(pRootOfTree.left != null){
//            pRootOfTree = pRootOfTree.left;
//        }
//        return pRootOfTree;
//    }
//}
////中序遍历和先序遍历构建二叉树
//class MyStack {
//    static int curIdx = 0;
//    public TreeNode _builderTree(int[] pre,int[] in,int inS,int inE){
//        //空树
//        if(inS>inE)
//            return null;
//        int rootValue = pre[curIdx++];
//        TreeNode root = new TreeNode(rootValue);
//        //区间除了根元素，没有孩子节点
//        if(inE == inS)
//            return root;
//        int i;
//        for( i=0;i<inE;i++){
//            if(in[i] == rootValue)
//                break;
//        }
//        root.left = _builderTree(pre, in, inS, i-1);
//        root.right = _builderTree(pre, in, i+1, inE);
//        return root;
//    }
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        curIdx = 0;
//        return _builderTree(preorder,inorder,0,preorder.length-1);
//    }
//}