class Solution {

    int m, n;
    Boolean[][][] dp;

    public boolean hasValidPath(char[][] grid) {

        m = grid.length;
        n = grid[0].length;
        if ((m + n - 1) % 2 != 0) {
            return false;
        }
        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') {
            return false;
        }

        dp = new Boolean[m][n][m + n];

        return dfs(0, 0, 0, grid);
    }

    private boolean dfs(int row, int col, int balance, char[][] grid) {
        if (grid[row][col] == '(') {
            balance++;
        } else {
            balance--;
        }
        if (balance < 0) {
            return false;
        }
        if (row == m - 1 && col == n - 1) {
            return balance == 0;
        }
        if (dp[row][col][balance] != null) {
            return dp[row][col][balance];
        }

        boolean result = false;
        if (row + 1 < m) {
            result = dfs(row + 1, col, balance, grid);
        }
        if (!result && col + 1 < n) {
            result = dfs(row, col + 1, balance, grid);
        }

        return dp[row][col][balance] = result;
    }
}