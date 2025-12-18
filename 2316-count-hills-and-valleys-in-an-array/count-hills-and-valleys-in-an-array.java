class Solution {
    public int countHillValley(int[] nums) {
        int count = 0;
        // int curr = 0;
        int n= nums.length;
        for(int i = 1; i<n-1; i++){
            int j = i+1;
            while(j<n && nums[i]==nums[j]){
                j++;
            }
            if(j==n)break;
            if(nums[i]>nums[i-1] && nums[i] >nums[j]){
                count++;
            }else if(nums[i] <nums[i-1] && nums[i]<nums[j]){
                count++;
            }
        }    
        return count;
    }
}