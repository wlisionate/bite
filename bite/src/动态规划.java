import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class 动态规划 {
    //最大子序列和
    public static int maxSubArray(int[] nums) {
        int dp[]=new int[nums.length+1];
        dp[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
        }
        int k=0;
        for(int i=0;i<nums.length;i++){
            if(dp[i]>dp[k])k=i;
        }
        return dp[k];
    }
    //最长递增子序列
    public static int lengthOfLIS(int[] nums){
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for(int i = 0;i<nums.length;i++){
            for(int j = 0;j<i;j++){
                if(nums[i] > nums[j])
                    dp[i] = Math.max(dp[i],dp[j]+1);
            }
        }
        int res = 0;
        for(int i = 0;i<dp.length;i++)
            res = Math.max(res,dp[i]);
        return res;
    }
    //0—1背包：动态规划    DP[N][W]    N个物品，背包容量为W时的最大价值
    public static int knapsack(int W,int N,int[]wt,int [] val){
        int[][] dp = new int[N+1][W+1];
        for(int i = 1;i<=N;i++){
            for(int w = 1;w<=W;w++){
                if(w-wt[i-1]<0){
                    dp[i][w] = dp[i-1][w];
                }else {
                    dp[i][w] = Math.max(dp[i-1][w-wt[i-1]]+val[i-1],dp[i-1][w]);
                }
            }
        }
        return dp[N][W];
    }
    /**
     * 编辑距离，最小变换次数
     * @param s1
     * @param s2
     * @return
     */
    public static int minDistance(String s1,String s2){
        int m = s1.length(),n = s2.length();
        int[][]dp = new int[m+1][n+1];
        //base case
        for(int i = 1;i<=m;i++){
            dp[i][0] = i;
        }
        for(int j = 1;j<=n;j++){
            dp[0][j] = j;
        }
        //自底向上求解
        for(int i = 1;i<=m;i++){
            for(int j = 1;j<=n;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = min(dp[i-1][j]+1,dp[i][j-1]+1,dp[i-1][j-1]+1);
            }
        }
        return dp[m][n];
    }
    public static int min(int a,int b,int c){
        return Math.min(a,Math.min(b,c));
    }
    public int superEggDrop(int K,int N){
        //dp[i][j]:一共有i层楼梯的情况下，使用j个鸡蛋的最少扔的次数
        int [][]dp = new int[N+1][K+1];
        //初始化
        for(int i = 0;i<=N;i++){
            Arrays.fill(dp[i],i);
        }
        for(int j = 0;j<=K;j++){
            dp[0][j] = 0;
        }
        dp[1][0] = 0;
        for(int j = 1;j<=K;j++){
            dp[1][j] = 1;
        }
        for (int i = 0;i<=N;i++){
            dp[i][0] = 0;
            dp[i][1] = i;
        }
        //开始递推
        for(int i = 2;i<=N;i++){
            for(int j = 2;j<=K;j++){
                int left = 1;
                int right = i;
                while (left<right){
                    //dp[k-1][j-1]<=dp[i-mid][j]的最大值K
                    int mid = left+(right-left+1)/2;
                    int breakCount = dp[mid-1][j-1];
                    int notBreakCount = dp[i-mid][j];
                    if(breakCount>notBreakCount){
                        // 排除法（减治思想）写对二分见第 35 题，先想什么时候不是解
                        // 严格大于的时候一定不是解，此时 mid 一定不是解
                        // 下一轮搜索区间是 [left, mid - 1]
                        right = mid-1;
                    }else {
                        // 这个区间一定是上一个区间的反面，即 [mid, right]
                        // 注意这个时候取中间数要上取整，int mid = left + (right - left + 1) / 2;
                        left = mid;
                    }
                }
                // left 这个下标就是最优的 k 值，把它代入转移方程 Math.max(dp[k - 1][j - 1], dp[i - k][j]) + 1) 即可
                dp[i][j] = Math.max(dp[left - 1][j - 1], dp[i - left][j]) + 1;
            }
        }
        return dp[N][K];
    }
    public static void main(String[] args) {
//        int []array = {-2,1,-3,4,-1,2,1,-5,4};
//        maxSubArray(array);
//        System.out.println(lengthOfLIS(array));
        String s1 = "intention";
        String s2 = "execution";
        System.out.println(minDistance(s1, s2));

    }
}