class Solution {
    public int minMoves(int[] nums) {
        int moves = 0;
        int n = nums.length;
        int max = nums[0];
        for (int i = 0; i < n; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        for (int i = 0; i < n; i++) {
            moves += max - nums[i];
        }
        return moves;
    }
}