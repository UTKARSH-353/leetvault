class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int totalTime = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            int gap = timeSeries[i + 1] - timeSeries[i];
            totalTime += Math.min(duration, gap);
        }
        totalTime += duration;
        return totalTime;
    }
}
