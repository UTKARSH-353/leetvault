class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];
        Queue<int[]> q = new LinkedList<>();

        // Push all rotten oranges (multi-source BFS)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    vis[i][j] = 1;
                    q.offer(new int[]{i, j, 0});   // {row, col, time}
                }
            }
        }

        int maxTime = 0;

        int[] row = {-1, 0, 1, 0};
        int[] col = {0, 1, 0, -1};

        // BFS
        while (!q.isEmpty()) {
            int[] curr = q.poll();

            int r = curr[0];
            int c = curr[1];
            int time = curr[2];

            maxTime = Math.max(maxTime, time);

            for (int i = 0; i < 4; i++) {
                int nr = r + row[i];
                int nc = c + col[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m &&
                    vis[nr][nc] == 0 && grid[nr][nc] == 1) {

                    vis[nr][nc] = 1;
                    grid[nr][nc] = 2;       // turn fresh → rotten
                    q.offer(new int[]{nr, nc, time + 1});
                }
            }
        }

        // Check if any fresh orange remains
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return maxTime;
    }
}

