package leetcode;

import bite11.二叉树非递归遍历.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/3/2 14:51
 * @Description:
 */
public class Solution1 {
    //递归顺序查找树
//    public TreeNode increasingBST(TreeNode root) {
//        List<Integer> integerList = new ArrayList<>();
//        inzhong(root,integerList);
//        TreeNode treeNode = new TreeNode(0);
//        TreeNode cur = treeNode;
//        for(int v:integerList){
//            cur.right = new TreeNode(v);
//            cur = cur.right;
//
//        }
//        return treeNode.right;
//    }
//    //中序便利
//    public void inzhong(TreeNode root,List<Integer> integers){
//        if (root != null){
//            inzhong(root.left,integers);
//            integers.add(root.val);
//            inzhong(root.right,integers);
//        }
//    }
    //  合并二叉树
//    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
//        if(t1 == null){
//            return t2;
//        }
//        if(t2 == null){
//            return t1;
//        }
//       t1.val = t1.val+t2.val;
//        t1.left = mergeTrees(t1.left,t2.left);
//        t1.right = mergeTrees(t1.right,t2.right);
//        return t1;
//    }
//    //把二叉搜索树转换为累加树
//    private int sum = 0;
//    public TreeNode convertBST(TreeNode root) {
//        if(root == null)
//            return null;
//        convertBST(root.right);
//        root.val+=sum;
//        sum = root.val;
//        convertBST(root.left);
//        return root;
//    }
}
