package cn.nshima.day01;

/**
 * @description:
 * @author:
 * @create: 2021-04-21-19-41
 */

public class C_05_LongestIncreasingPath {

    /**
     * 方法1：暴力递归
     *
     * 超时
     * */

    //给定一个二维数组，任选一个位置，求能走出的最长递增链长度
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;

        int ans = 0;
        for(int i = 0; i < matrix.length; ++i){
            for(int j = 0; j < matrix[0].length; ++j) {
                ans = Math.max(ans,process1(matrix,i,j));
            }
        }

        return ans;
    }


    //从(i,j)位置开始走，求能走出来的最长的递增链长度
    private int process1(int[][] matrix,int i, int j) {
        int up = i > 0 && matrix[i-1][j] > matrix[i][j] ? process1(matrix,i - 1, j) : 0;
        int down = i < matrix.length - 1 && matrix[i+1][j] > matrix[i][j] ? process1(matrix,i+1, j) : 0;
        int left = j > 0 && matrix[i][j-1] > matrix[i][j] ? process1(matrix,i,j-1) : 0;
        int right = j < matrix[0].length - 1 && matrix[i][j+1] > matrix[i][j] ? process1(matrix,i,j+1) : 0;

        return Math.max( Math.max(up,down), Math.max(left,right) ) + 1;
    }

    /**
     * 方法2：暴力递归基础上加简单缓存
     *
     *用时9ms,内存消耗38.8MB
     * */
    public int longestIncreasingPath2(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return 0;
        }

        int[][] dp = new int[matrix.length][matrix[0].length];
        int ans = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0;j < matrix[0].length; j++) {
                ans = Math.max(ans,process2(matrix,i,j,dp));
            }
        }
        return ans;
    }

    //从m[i][j]位置开始走，走出来的最长递增链，返回长度
    public static int process2(int[][] matrix,int i, int j, int[][] dp) {
        if(dp[i][j] != 0) {
            return dp[i][j];
        }


        int up = i > 0 && matrix[i-1][j] > matrix[i][j] ? process2(matrix,i-1,j,dp) : 0;
        int down = i < matrix.length - 1 && matrix[i+1][j] > matrix[i][j] ? process2(matrix,i + 1,j, dp) : 0;
        int left = j > 0 && matrix[i][j-1] > matrix[i][j] ? process2(matrix,i,j - 1, dp) : 0;
        int right = j < matrix[0].length - 1 && matrix[i][j + 1] > matrix[i][j] ? process2(matrix,i, j + 1, dp) : 0;

        int ans = Math.max(Math.max(up,down), Math.max(left,right)) + 1;
        dp[i][j] = ans;

        return ans;
    }
}
