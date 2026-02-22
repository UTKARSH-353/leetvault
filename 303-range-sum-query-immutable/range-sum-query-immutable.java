class NumArray {
    int numArr[];
    public NumArray(int[] nums) {
        int n = nums.length;
        numArr = new int[n+1];
        numArr[0] = 0;
        for(int i = 1; i<=n; i++){
            numArr[i] = numArr[i-1] + nums[i-1];
        }
    }
    
    public int sumRange(int left, int right) {
        return numArr[right+1]- numArr[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */