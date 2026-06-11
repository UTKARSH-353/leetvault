class Solution {

    int[][] dp;
    int[] cuts;

    public int minCost(int n, int[] cutsArr) {

        int m = cutsArr.length;

        cuts = new int[m + 2];
        cuts[0] = 0;
        cuts[m + 1] = n;

        for (int i = 0; i < m; i++) {
            cuts[i + 1] = cutsArr[i];
        }

        Arrays.sort(cuts);

        dp = new int[m + 2][m + 2];

        return solve(0, m + 1);
    }

    private int solve(int i, int j) {

        if (j - i <= 1) {
            return 0;
        }

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;

        for (int k = i + 1; k < j; k++) {

            ans = Math.min(
                ans,
                cuts[j] - cuts[i]
                + solve(i, k)
                + solve(k, j)
            );
        }

        return dp[i][j] = ans;
    }
}