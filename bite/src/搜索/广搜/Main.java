package 搜索.广搜;

import java.util.*;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
public class Main {
    /**
     * n叉树的遍历
     * @param root
     * @return
     */
//    public List<List<Integer>> levelOrder(Node root) {
//        List<List<Integer>> treeLev = new ArrayList<>();
//        if(root == null)
//            return treeLev;
//        Queue<Node> queue = new LinkedList<>();
//        queue.offer(root);
//        while (!queue.isEmpty()){
//            int size = queue.size();
//            List<Integer> list = new ArrayList<>();
//            while (size>0){
//                Node cur =  queue.poll();
//                list.add(cur.val);
//                for(Node node:cur.children){
//                    queue.offer(node);
//                }
//                size--;
//            }
//            treeLev.add(list);
//        }
//        return treeLev;
//    }

    /**
     * 腐烂的橘子
     * @param grid
     * @return
     */
//    int [][] array = {{0,1},{0,-1},{1,0},{-1,0}};
//    public int orangesRotting(int[][] grid) {
//        Queue<Pair> queue = new LinkedList<>();
//        int minutes = 0;
//        boolean flag = false;
//        int row = grid.length;
//        int col = grid[0].length;
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                if (grid[i][j] == 2) {
//                    Pair pair = new Pair(i, j);
//                    queue.offer(pair);
//                }
//            }
//        }
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            flag = false;
//            while (size-- > 0) {
//
//                Pair pair = queue.poll();
//                for (int i = 0; i < 4; i++) {
//                    int newX = pair.x + array[i][0];
//                    int newY = pair.y + array[i][1];
//                    if (newX < 0 || newX >= row || newY < 0 || newY >= col)
//                        continue;
//                    if (grid[newX][newY] == 1) {
//                        flag = true;
//                        grid[newX][newY] = 2;
//                        Pair pair1 = new Pair(newX, newY);
//                        queue.offer(pair1);
//                    }
//                }
//            }
//            if (flag)
//                minutes++;
//        }
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                if (grid[i][j] == 1)
//                    return -1;
//            }
//        }
//        return minutes;
//    }

    /**
     * 单词接龙
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        for(String s:wordList){
//            if(!s.equals(endWord))
//                return 0;
//        }
//        int res = 1;
//        Set<String> setList = new HashSet<>();
//        for(String s:wordList)
//            setList.add(s);
//        Set<String> visited = new HashSet<>();
//        visited.add(beginWord);
//        Queue<String> queue = new LinkedList<>();
//        queue.offer(beginWord);
//        while (!queue.isEmpty()){
//            int size = queue.size();
//            while (size-->0){
//                String s = queue.poll();
//                for(int i = 0;i<s.length();i++){
//                    StringBuffer sb = new StringBuffer(s);
//                    for(char c = 'a';c<='z';c++){
//                        sb.setCharAt(i,c);
//                        String s1 = sb.toString();
//                        if(!setList.contains(s1) || visited.contains(s1))
//                            continue;
//                        if(s1.equals(endWord))
//                            return res+1;
//                        visited.add(s1);
//                        queue.offer(s1);
//                    }
//                }
//            }
//        }
//        return 0;
//    }

    /**
     * 最小基因变化
     * @param start
     * @param end
     * @param bank
     * @return
     */
//    char[] array = {'A','C','G','T'};
//    public int minMutation(String start, String end, String[] bank) {
//        Set<String> setList = new HashSet<>();
//        for(String s:bank){
//            setList.add(s);
//        }
//        int res = 1;
//        Set<String> visited = new HashSet<>();
//        visited.add(start);
//        Queue<String> queue = new LinkedList<>();
//        queue.offer(start);
//        while (!queue.isEmpty()){
//            int size = queue.size();
//            while (size-->0){
//                String s = queue.poll();
//                for(int i = 0;i<s.length();i++){
//                    StringBuffer sb = new StringBuffer(s);
//                    for(int j = 0;j<array.length;j++){
//                        sb.setCharAt(i,array[j]);
//                        String s1 = sb.toString();
//                        if(!setList.contains(s1) || visited.contains(s1))
//                            continue;
//                        if(s1.equals(end))
//                            return res+1;
//                        queue.offer(s1);
//                        visited.add(s1);
//                    }
//                }
//            }
//            res++;
//        }
//        return 0;
//    }

    /**
     * 打开转盘锁
     * @param deadends
     * @param target
     * @return
     */
    public static int openLock(String[] deadends, String target) {
        Set<String> setList = new HashSet<>();
        for(String s:deadends)
            setList.add(s);
        Set<String> book = new HashSet<>();
        if(setList.contains("0000"))
            return -1;
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        book.add("0000");
        int step = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-->0){
                String cur = queue.poll();
                if (cur.equals(target))
                    return step;
                for(int i = 0;i<cur.length();i++){
                    char new1 = cur.charAt(i);
                    char new2 = cur.charAt(i);
                    new1 = new1 == '9'?'0':++new1;
                    new2 = new2 == '0'?'9':--new2;
                    StringBuilder sb1 = new StringBuilder(cur);
                    StringBuilder sb2 = new StringBuilder(cur);
                    sb1.setCharAt(i,new1);
                    sb2.setCharAt(i,new2);
                    if(!setList.contains(sb1.toString()) && !book.contains(sb1.toString())){
                        queue.offer(sb1.toString());
                        book.add(sb1.toString());
                    }
                    if(!setList.contains(sb2.toString()) && !book.contains(sb2.toString())){
                        queue.offer(sb2.toString());
                        book.add(sb2.toString());
                    }
                }
            }
            step++;
        }
        return step;
    }

    public static void main(String[] args) {
    }
}
class Pair{
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
