// class Solution {
//     String maxResult = "";
//     public String largestNumber(int[] nums) {
//         boolean[] used = new boolean[nums.length];
//         backtrack(nums, used, "");
//         return maxResult;
//     }
//     void backtrack(int[] nums, boolean[] used, String curr) {
//         if (curr.length() == totalLength(nums)) {
//             if (curr.compareTo(maxResult) > 0) {
//                 maxResult = curr;
//             }
//             return;
//         }
//         for (int i = 0; i < nums.length; i++) {
//             if (!used[i]) {
//                 used[i] = true;
//                 backtrack(nums, used, curr + nums[i]);
//                 used[i] = false;
//             }
//         }
//     }
//     int totalLength(int[] nums) {
//         int len = 0;
//         for (int num : nums) len += String.valueOf(num).length();
//         return len;
//     }
// }



class Solution {
    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for(int num : nums){
            list.add(String.valueOf(num));
        }
        List<String>[] buckets = new List[10];
        for(int i=0; i<10; i++){
            buckets[i] = new ArrayList<>();
        }
        for(String s : list){
            int firstDigit = s.charAt(0) - '0';
            buckets[firstDigit].add(s);
        }
        for(int i=0; i<10; i++){
            buckets[i].sort((a,b) -> (b + a).compareTo(a + b));
        }
        StringBuilder sb = new StringBuilder();
        for(int d = 9; d >= 0; d--){
            for(String s : buckets[d]){
                sb.append(s);
            }
        }
        if(sb.charAt(0) == '0') return "0";
        return sb.toString();
    }
}
