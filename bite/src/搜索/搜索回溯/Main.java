package 搜索.搜索回溯;

import java.util.*;

public class Main {
    /**
     * 电话号码的字母组合
     * @param digits
     * @return
     */
//    String []mapString = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
//    public void dfs(String digits,List<String> list,StringBuilder cur,int curDepth){
//        if(curDepth == digits.length()){
//            if(cur.length() != 0)
//                list.add(cur.toString());
//            return;
//        }
//        String curMap = mapString[digits.charAt(curDepth)-'0'];
//        for(int i = 0;i<curMap.length();i++){
//            dfs(digits,list,cur.append(curMap.charAt(i)),curDepth+1);
//            cur.deleteCharAt(cur.length()-1);
//        }
//    }
//    public List<String> letterCombinations(String digits) {
//        List<String> list = new ArrayList<>();
//        StringBuilder sb = new StringBuilder("");
//        dfs(digits,list,sb,0);
//        return list;
//    }

    /**
     * 组合总和
     * @param listList
     * @param list
     * @param sum
     * @param prePosition
     * @param target
     * @param candidates
     */
//    public void dfs(List<List<Integer>> listList,List<Integer> list,int sum,int prePosition,int target,int[] candidates){
//        if (sum >= target){
//            if(sum == target){
//                List<Integer> list1  = new ArrayList<>();
//                for(int e:list)
//                    list1.add(e);
//                listList.add(list1);
//            }
//            return;
//        }
//        for(int i = prePosition;i<candidates.length;i++){
//            list.add(candidates[i]);
//            dfs(listList,list,,sum+candidates[i],i,target,candidates);
//            list.remove(list.size()-1);
//        }
//    }
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        List<List<Integer>> listList = new ArrayList<>();
//        List<Integer> list = new ArrayList<>();
//        dfs(listList,list,0,0,target,candidates);
//        return listList;
//    }

    /**
     * 活字印刷
     * @param tiles
     * @return
     */
//    public void dfs(Set<String> set,StringBuilder sb,String tiles,int []book){
//        if(sb.length() != 0)
//            set.add(sb.toString());
//        for(int i = 0;i<tiles.length();i++){
//            if(book[i] == 1){
//                continue;
//            }
//            book[i] = 1;
//            dfs(set,sb.append(tiles.charAt(i)),tiles,book);
//            book[i] = 0;
//            sb.deleteCharAt(sb.length()-1);
//        }
//    }
//    public int numTilePossibilities(String tiles) {
//        Set<String> strings = new HashSet<>();
//        StringBuilder sb = new StringBuilder("");
//        int [] book = new int[tiles.length()];
//        dfs(strings,sb,tiles,book);
//        return strings.size();
//    }

    /**
     * N皇后
     * @param n
     * @return
     */
    public static void dfs(List<List<Pair>> listList,List<Pair> list,int curRow,int n){
        if(curRow == n){
            List<Pair> newP = new ArrayList<>();
            for(Pair p:list){
                newP.add(p);
            }
            listList.add(newP);
            return;
        }
        for(int i = 0;i<n;i++){
            if(isValid(list,i,curRow)){
                list.add(new Pair(curRow,i));
                dfs(listList,list,curRow+1,n);
                list.remove(list.size()-1);
            }
        }
    }

    private static boolean isValid(List<Pair> list, int i, int curRow) {
        for(Pair pair:list){
            if(pair.y == i || i+curRow == pair.y+pair.x || curRow-i == pair.x-pair.y)
                return false;
        }
        return true;
    }
    public static List<List<String>> toStringQueue(List<List<Pair>> solutions,int n){
        List<List<String>> ret = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        for(List<Pair> solution:solutions){
            List<StringBuilder> solutionString = new ArrayList<>();
            for(int i = 0;i<n;i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0;j<n;j++){
                    sb.append('.');
                }
                solutionString.add(sb);
            }
            for(Pair i : solution){
                solutionString.get(i.x).setCharAt(i.y,'Q');
            }
            List<String> curRet = new ArrayList<>();
            for(StringBuilder sb:solutionString){
                curRet.add(sb.toString());
            }
            ret.add(curRet);
        }
        return ret;
    }
    public static List<List<String>> solveNQueens(int n) {
        List<List<Pair>> lists = new ArrayList<>();
        List<Pair> list = new ArrayList<>();
        dfs(lists,list,0,n);
        return toStringQueue(lists,n);
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
}
class Pair{
    public int x;
    public int y;
    public Pair(int x,int y){
        this.x = x;
        this.y = y;
    }
}
