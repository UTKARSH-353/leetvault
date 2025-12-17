class Solution {
    public int rob(int[] nums) {
        int h2 = 0; 
        int h1 = 0; 

        for (int money : nums) {
            int curr = Math.max(h1, h2 + money);
            h2 = h1;
            h1 = curr;
        }
        return h1;
    }
}
