package 搜索.深搜;

import sun.security.krb5.internal.rcache.DflCache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
public class Main {
    /**
     * leetcode：员工的重要性
     */
//    public int DFS(int id,Map<Integer,Employee> map){
//        int sum = 0;
//        sum += map.get(id).importance;
//        for(Integer i:map.get(id).subordinates){
//            sum += DFS(i,map);
//        }
//        return sum;
//    }
//    public int getImportance(List<Employee> employees, int id) {
//        Map<Integer,Employee> map = new HashMap<>();
//        for(Employee e:employees){
//            map.put(e.id,e);
//        }
//        return DFS(id,map);
//    }

    /**
     *leetcode：图像渲染
     * @param image
     * @param sr
     * @param sc
     * @param newColor
     * @return
     */
//    int [][] array = {{0,1},{1,0},{0,-1},{-1,0}};
//    public void DFS(int[][] image,int row,int col,int curX,int curY,int oldColor,int newColor,int[][] book){
//        image[curX][curY] = newColor;
//        book[curX][curY] = 1;
//        for(int i = 0;i<4;i++){
//            int newX = curX+array[i][0];
//            int newY = curY+array[i][1];
//            if(newX<0||newX>=row||newY<0||newY>=col)
//                continue;
//            if(image[newX][newY] == oldColor&& book[newX][newY] == 0){
//                DFS(image,row,col,newX,newY,oldColor,newColor,book);
//            }
//        }
//    }
//    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
//        int row = image.length;
//        int col = image[0].length;
//        int [][] book = new int[row][col];
//        int oldColor = image[sr][sc];
//        DFS(image,row,col,sr,sc,oldColor,newColor,book);
//        return image;
//    }
    /**
     * leetcode:被围绕的区域
     */
//    int [][]array = {{0,1},{0,-1},{-1,0},{1,0}};
//    public void DFS(char[][] board,int curX,int curY,int row,int col,int [][] book){
//        board[curX][curY] = 'A';
//        book[curX][curY] = 1;
//        for(int i = 0;i<4;i++){
//            int newX = curX+array[i][0];
//            int newY = curY+array[i][1];
//            if(newX<0 || newX>=row||newY<0 || newY>=col)
//                continue;
//            if(board[newX][newY] == 'O' && book[newX][newY] == 0){
//                DFS(board,newX,newY,row,col,book);
//            }
//        }
//    }
//    public void solve(char[][] board) {
//        if(board.length == 0)
//            return;
//        int row = board.length;
//        int col = board[0].length;
//        int [][] book = new int[row][col];
//        for(int i = 0;i<col;i++){
//            if(board[0][i] == 'O' && book[0][i] == 0)
//                DFS(board,0,i,row,col,book);
//            if(board[row-1][i] == 'O' && book[row-1][i] == 0)
//                DFS(board,row-1,i,row,col,book);
//        }
//        for(int i = 0;i<row;i++){
//            if(board[i][0] == 'O' && book[i][0] == 0)
//                DFS(board,i,0,row,col,book);
//            if(board[i][col-1] == 'O' && book[i][col-1] == 0)
//                DFS(board,i,col-1,row,col,book);
//        }
//        for (int i = 0;i<row;i++){
//            for(int j = 0;j<col;j++){
//                if(board[i][j] == 'A'){
//                    board[i][j] = 'O';
//                }
//                else if(board[i][j] == 'O'){
//                    board[i][j] = 'X';
//                }
//            }
//        }
//    }
    /**
     * 岛屿数量
     */
    int [][]array = {{-1,0},{1,0},{0,-1},{0,1}};
    public void DFS(char[][] grid,int row,int col,int curX,int curY,int[][]book){
        book[curX][curY] = 1;
        for(int i = 0;i<4;i++){
            int newX = curX+array[i][0];
            int newY = curY+array[i][1];
            if(newX<0 || newX>=row || newY<0 || newY>=col)
                continue;
            if(grid[newX][newY] == '1' && book[newX][newY] == 0){
                DFS(grid, row, col, newX, newY, book);
            }
        }
    }
    public int numIslands(char[][] grid) {
        if(grid.length == 0)
            return 0;
        int sum = 0;
        int row = grid.length;
        int col = grid[0].length;
        int [][] book = new int[row][col];
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                if(grid[i][j] == '1' && book[i][j] == 0){
                    sum++;
                    DFS(grid,row,col,i,j,book);
                }
            }
        }
        return sum;
    }
}
