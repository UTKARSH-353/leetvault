class Solution {
    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int MOD = 1_000_000_007;

        long[][] horizontal = new long[m][n];
        long[][] vertical = new long[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                long right = horizontal[i][j];
                long down = vertical[i][j];

                if (i == 0 && j == 0) {
                    right = 1;
                }

                if (grid[i][j] == 1) {

                    if (i + 1 < m) {
                        vertical[i + 1][j] =
                            (vertical[i + 1][j] + right) % MOD;
                    }

                    if (j + 1 < n) {
                        horizontal[i][j + 1] =
                            (horizontal[i][j + 1] + down) % MOD;
                    }

                } else {

                    long ways = (right + down) % MOD;
                    
                    if (j + 1 < n) {
                        horizontal[i][j + 1] =
                            (horizontal[i][j + 1] + ways) % MOD;
                    }
                    
                    if (i + 1 < m) {
                        vertical[i + 1][j] =
                            (vertical[i + 1][j] + ways) % MOD;
                    }
                    if (i == m - 1 && j == n - 1) {
                        return (int) ways;
                    }
                }
            }
        }

        return 0;
    }
}