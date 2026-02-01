class Solution {
    public long[] unmarkedSumArray(int[] nums, int[][] queries) {
        int n = nums.length;
        long totalSum = 0;
        boolean[] marked = new boolean[n];
        long[] ans = new long[queries.length];
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> {
                if (a[0] == b[0]) return a[1] - b[1];
                return a[0] - b[0];
            });
        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
            pq.add(new int[]{nums[i], i});
        }
        for (int q = 0; q < queries.length; q++) {
            int index = queries[q][0];
            int k = queries[q][1];
            if (!marked[index]) {
                marked[index] = true;
                totalSum -= nums[index];
            }
            while (k > 0 && !pq.isEmpty()) {
                int[] cur = pq.poll();
                int val = cur[0];
                int idx = cur[1];
                if (!marked[idx]) {
                    marked[idx] = true;
                    totalSum -= val;
                    k--;
                }
            }
            ans[q] = totalSum;
        }
        return ans;
    }
}
