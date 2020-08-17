import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

//
//
//import java.util.*;
//
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()){
//            int n = sc.nextInt();
//            float sum = all(n);
//            float num = noGet(n);
//            float result = (num/sum)*100;
//            System.out.println(String.format("%.2f",result)+"%");
//        }
//    }
//    //所有的情况
//    public static float all(int n){
//        float sum = 1;
//        while (n>0){
//            sum*=n;
//            n--;
//        }
//        return sum;
//    }
//    //无人中奖的可能
//    public static float noGet(int n){
//        if(n == 1)
//            return 0;
//        if(n == 2)
//            return 1;
//        return (n-1)*(noGet(n-1)+noGet(n-2));
//    }
//}
//public class Main{
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int sum = sc.nextInt();
//        int [] array = new int[n];
//        for(int i = 0;i<n;i++){
//            array[i] = sc.nextInt();
//        }
//
//        long [][]dp = new long[n+1][sum+1];//n个物品和为sum有多少方案。
//        //表示当和为0是，就只有不取一种方案。
//        for(int i = 0;i<=n;i++){
//            dp[i][0] = 1;
//        }
//        //表示没有数字的时候就没有方案，但是这里要注意dp[0][0] = 1
//        for(int i = 1;i<=sum;i++){
//            dp[0][i] = 0;
//        }
//        for(int i = 1;i<=n;i++){
//            for(int j = 0;j<=sum;j++){
//                if(array[i-1] <=j){
//                    //表示这个数字放入多少种方案加上这个不放入有多少种方案
//                    dp[i][j] = dp[i-1][j]+dp[i-1][j-array[i-1]];
//                }else {
//                    dp[i][j] = dp[i-1][j];
//                }
//            }
//        }
//        System.out.println(dp[n][sum]);
//    }
//    static int n = 0,m = 0,maxEnergy = 0;
//    static int[][] map;
//    static boolean flag = false;
//    static String path = "";
//    static LinkedList<String> list = new LinkedList<>();
//
//    public static void main(String[] args) {
//        int p;
//        Scanner s = new Scanner(System.in);
//        if(s.hasNext()){
//            n = s.nextInt();
//            m = s.nextInt();
//            p = s.nextInt();
//            map = new int[n][m];
//            for(int i = 0;i<n;i++){
//                for(int j = 0;j<m;j++){
//                    map[i][j] = s.nextInt();
//                }
//            }
//            runMap(0,0,p);
//            if(flag){
//                System.out.println(path);
//            }else {
//                System.out.println("Can not escape");
//            }
//        }
//    }
//    //更新路径
//    public static void updataPath(){
//        StringBuffer sb = new StringBuffer();
//        Iterator<String> i = list.iterator();
//        while (i.hasNext()){
//            sb.append(i.next()+",");
//        }
//        if(sb.length()>0){
//            sb.deleteCharAt(sb.length()-1);
//        }
//        path = sb.toString();
//    }
//
//    //开始走迷宫
//    public static void runMap(int x,int y,int energy){
//        if(x<0 || y<0 || x>=m || y>=n || energy<0 || map[x][y] != 1){
//            return;
//        }
//        map[x][y] = 2;
//        list.offer("["+x+","+y+"]");
//        if(x==0 && y==m-1){
//            if(energy >= maxEnergy){
//                maxEnergy = energy;
//                updataPath();
//            }
//            map[x][y] = 1;
//            list.removeLast();
//            flag = true;
//            return;
//        }
//        runMap(x-1,y,energy-3);
//        //往右走
//        runMap(x, y+1, energy-1);
//        //往下走
//        runMap(x+1, y, energy);
//        //往左走
//        runMap(x, y-1, energy-1);
//        //如果往上下左右四个方向都走不通，就沿原路返回，到上一个节点处在看能不能往其他方向走
//        map[x][y] = 1;
//        list.removeLast();
//    }
//
//}
public class Main{
    public static void main(String[] args) {

    }
}