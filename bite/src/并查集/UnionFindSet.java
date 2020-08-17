package 并查集;

import java.util.ArrayList;
import java.util.List;

public class UnionFindSet {
    private List<Integer> ufs;
    public UnionFindSet(int size){
        ufs = new ArrayList<>(size);
    }
    //找到集合根，也可以理解为集合的名称
    public int findRoot(int index){
        while (ufs.get(index) >= 0){
            index = ufs.get(index);
        }
        return index;
    }
    //对集合进行合并
    public boolean union(int x1,int x2){
        int root1 = findRoot(x1);
        int root2 = findRoot(x2);

        if(root1 == root2)
            return false;
        ufs.set(root1,ufs.get(root2));
        ufs.set(root2,root1);
        return true;
    }
    //返回集合的个数
    public int count(){
        int count = 0;
        for(int e:ufs){
            if(e<0)
                count++;
        }
        return count;
    }
    public static void main(String[] args) {

    }
}
