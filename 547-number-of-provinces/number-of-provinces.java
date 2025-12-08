class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        int count = 0; 
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                count++;
                q.add(i);
                vis[i] = true;
                while (!q.isEmpty()) {
                    int node = q.poll();
                    for (int j = 0; j < n; j++) {
                        if (isConnected[node][j] == 1 && !vis[j]) {
                            vis[j] = true;
                            q.add(j);
                        }
                    }
                }
            }
        }
        return count;
    }
}
