class Solution {
    public int absDifference(int[] nums, int k) {
        Arrays.sort(nums);

        int smSum = 0;
        int larSum = 0;
        int n = nums.length;
        for(int i = 0; i<k; i++){
            smSum += nums[i];

        }
        for(int i = n-1; i>=n-k;i--){
            larSum += nums[i];

        }
        return Math.abs(larSum-smSum);
    }
}