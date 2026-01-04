class Solution {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        // int i = 0;
        int nums1 = nums[n - 1] * nums[n - 2];
        int nums2 =nums[0] * nums[1];
        return nums1 - nums2;
    }
}