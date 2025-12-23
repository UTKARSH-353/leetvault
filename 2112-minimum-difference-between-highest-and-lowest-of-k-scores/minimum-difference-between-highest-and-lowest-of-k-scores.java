class Solution {
    public int minimumDifference(int[] nums, int k) {
        if (k == 1) return 0;
        Arrays.sort(nums);
        int n = nums.length;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i + k - 1 < n; i++) {
            diff = Math.min(diff, nums[i + k - 1] - nums[i]);
        }
        return diff;
    }
}
