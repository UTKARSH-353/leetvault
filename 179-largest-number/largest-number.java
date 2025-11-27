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
