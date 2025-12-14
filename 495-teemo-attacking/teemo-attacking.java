class Solution {
    public int findPoisonedDuration(int[] tSeries, int duration) {
        int tTime = 0;

        for (int i = 0; i < tSeries.length - 1; i++) {
            int gap = tSeries[i + 1] - tSeries[i];
            tTime += Math.min(duration, gap);
        }
        tTime += duration;
        return tTime;
    }
}
