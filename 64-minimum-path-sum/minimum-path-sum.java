class Solution {
    public int minPathSum(int[][] grid) {
       int m = grid.length;
       int n = grid[0].length;

       Integer[][] dp = new Integer[m][n];
       return solve(grid, 0, 0, dp );

}
public int solve(int[][] grid, int i, int j, Integer[][] dp){
    int m = grid.length;
    int n = grid[0].length;

    if(i >= m || j>= n){
        return Integer.MAX_VALUE / 2;
    }
    if(i == m-1 && j==n-1){
        return grid[i][j];

    }
    if(dp[i][j] != null){
        return dp[i][j];
    }

    int right = solve(grid, i, j +1, dp);
    int down = solve(grid, i+1, j, dp);

    dp[i][j] = grid[i][j] + Math.min(right, down);

    return dp[i][j];
}
}