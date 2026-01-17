class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int[] minutes = new int[n];
        for (int i = 0; i < n; i++) {
            String t = timePoints.get(i);
            int hour = Integer.parseInt(t.substring(0, 2));
            int min = Integer.parseInt(t.substring(3, 5));
            minutes[i] = hour * 60 + min;
        }
        Arrays.sort(minutes);
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            ans = Math.min(ans, minutes[i] - minutes[i - 1]);
        }
        int circular = 1440 - minutes[n - 1] + minutes[0];
        ans = Math.min(ans, circular);
        return ans;
    }
}
