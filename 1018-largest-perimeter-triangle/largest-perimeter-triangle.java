class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums); // Sort acs order

        for (int i = nums.length - 1; i >= 2; i--) {
            int a = nums[i], b = nums[i-1], c = nums[i-2];
            //check triangle
            if (b + c > a) {  
                return a + b + c; //largest perimeter
            }
        }
        return 0; 
    }
}
