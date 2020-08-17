package 并查集.leetcode;

import 并查集.UnionFindSet;

import java.util.Arrays;

public class Main {
    /**
     * \朋友圈
     * @param parent
     * @param i
     * @return
     */
    public int findRoot(int [] parent,int i){
        while (parent[i] != -1)
            i = parent[i];
        return i;
    }
    public void union(int[] parent,int i,int j){
        int iRoot = findRoot(parent,i);
        int jRoot = findRoot(parent,j);
        if(iRoot != jRoot)
            parent[iRoot] = jRoot;
    }
    public int findCircleNum(int[][] M) {
        int []parent = new int[M.length];
        Arrays.fill(parent,-1);
        for(int i = 0;i<M.length;i++){
            for(int j = 0;j<M[0].length;j++){
                if(M[i][j] == 1 && i != j)
                    union(parent,i,j);
            }
        }
        int count = 0;
        for(int i = 0;i<M.length;i++){
            if(parent[i] == -1)
                count++;
        }
        return count;
    }

    /**
     * 等式方程的可满足性
     * @param equations
     * @return
     */
//    public boolean equationsPossible(String[] equations) {
//        int[] parent = new int[26];
//        for(int i = 0;i<parent.length;i++)
//            parent[i] = i;
//        for(String s:equations){
//            if(s.charAt(1) == '='){
//                int index1 = s.charAt(0)-'0';
//                int index2 = s.charAt(3)-'0';
//                union(parent,index1,index2);
//            }
//        }
//        for(String s:equations){
//            if (s.charAt(1) == '!'){
//                int index1 = s.charAt(0)-'0';
//                int index2 = s.charAt(3)-'0';
//                if(find_Root(parent,index1) == find_Root(parent,index2))
//                    return false;
//            }
//        }
//        return true;
//    }
//    public int find_Root(int []parent,int i){
//        int index = 0;
//        while (parent[i] != i) {
//            parent[index] = parent[parent[index]];
//            index = parent[i];
//        }
//        return index;
//    }
//    public void union(int []parent,int i,int j){
//        parent[find_Root(parent,i)] = find_Root(parent,j);
//    }

}
