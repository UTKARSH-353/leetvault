class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> Double.compare(arr[a[0]] * 1.0 / arr[a[1]], arr[b[0]] * 1.0 / arr[b[1]])
        );
        for (int i = 0; i < n - 1; i++) {
            pq.offer(new int[]{i, n - 1}); 
        }
        while (k-- > 1) {
            int[] top = pq.poll();
            int i = top[0], j = top[1];
            if (j - 1 > i) {
                pq.offer(new int[]{i, j - 1});
            }
        }
        int[] ans = pq.poll();
        return new int[]{arr[ans[0]], arr[ans[1]]};
    }
}
