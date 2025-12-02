class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int res[] = new int[nums.length];
        int idx = 0;

        for (int n : nums) {
            if (n % 2 == 0) {
                res[idx++] = n; 
            }
        }
        for (int n : nums) {
            if (n % 2 != 0) {
                res[idx++] = n; 
            }
        }
        return res;
    }
}
