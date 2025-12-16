class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] sort = nums.clone();
        Arrays.sort(sort);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (sort[j] == nums[i]) {
                    ans[i] = j;
                    break;
                }
            }
        }
        return ans;
    }
}
