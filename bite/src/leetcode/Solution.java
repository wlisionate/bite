//package leetcode;
//
//import javax.swing.tree.TreeNode;
//
///**
// * Definition for a binary tree node.
// * public class TreeNode {
// *     int val;
// *     TreeNode left;
// *     TreeNode right;
// *     TreeNode(int x) { val = x; }
// * }
// */
//class MyStack {
//    //判断两棵树是否相等
//    public boolean isEqual(TreeNode l,TreeNode j){
//        if(l == null && j == null) return true;
//        if(l == null || j == null) return false;
//        if(l.val == j.val){
//            return isEqual(l.left,j.left)&&isEqual(l.right,j.right);
//        }
//        return false;
//    }
//    //判断是否是子树
//    public boolean isSubtree(TreeNode s, TreeNode t) {
//        if(s == null && t == null) return true;
//        if(s == null || t == null) return false;
//        if(s.val == t.val){
//            return isEqual(s,t) || isSubtree(s.left,t) || isSubtree(s.right,t);
//        }
//        return isSubtree(s.left,t) || isSubtree(s.right,t);
//    }
//}