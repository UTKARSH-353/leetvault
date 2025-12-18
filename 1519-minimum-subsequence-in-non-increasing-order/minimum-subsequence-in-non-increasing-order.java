class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);  
        int tSum = 0;
        for (int num : nums) {
            tSum += num;
        }
        List<Integer> ans = new ArrayList<>();
        int sSum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            sSum += nums[i];
            tSum -= nums[i];
            ans.add(nums[i]);
            if (sSum > tSum) {
                break;
            }
        }
        return ans;
    }
}
