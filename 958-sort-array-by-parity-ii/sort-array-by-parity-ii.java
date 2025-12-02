class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int res[] = new int[nums.length];
        int idxEven = 0;
        int idxOdd = 1;
        for(int n : nums){
            if(n % 2 == 0){
                res[idxEven] = n;
                idxEven += 2;
            }else{
                res[idxOdd] = n;
                idxOdd += 2;
            }
        }
        // if(idx % == 0){
        //     idx++;
            
        // }else{

        // }
        return res;
    }
}