class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> ans = new ArrayList<>();
        // int length = nums.length;
        for(int i = 0; i< nums.length; i++){
            int value = 0;
            for(int j = 0; j <= i; j++){
                value = (value * 2 + nums[j]) % 5;
            }
            ans.add(value == 0);

        } 
        return ans;
    }
}