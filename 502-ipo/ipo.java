class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> minCapitalHeap =
            new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> maxProfitHeap =
            new PriorityQueue<>(Collections.reverseOrder());
        int n = profits.length;
        for (int i = 0; i < n; i++) {
            minCapitalHeap.offer(new int[]{capital[i], profits[i]});
        }
        int currCapital = w;
        for (int i = 0; i < k; i++) {
            while (!minCapitalHeap.isEmpty() &&
                   minCapitalHeap.peek()[0] <= currCapital) {
                maxProfitHeap.offer(minCapitalHeap.poll()[1]);
            }
            if (maxProfitHeap.isEmpty()) break;
            currCapital += maxProfitHeap.poll();
        }
        return currCapital;
    }
}
