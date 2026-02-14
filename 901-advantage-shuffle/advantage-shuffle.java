class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] result = new int[n];
        Arrays.sort(nums1);
        Integer[] index = new Integer[n];
        for (int i = 0; i < n; i++) index[i] = i;
        Arrays.sort(index, (a, b) -> nums2[a] - nums2[b]);
        int left = 0;
        int right = n - 1;
        for (int num : nums1) {
            if (num > nums2[index[left]]) {
                result[index[left]] = num;
                left++;
            } else {
                result[index[right]] = num;
                right--;
            }
        }
        return result;
    }
}
