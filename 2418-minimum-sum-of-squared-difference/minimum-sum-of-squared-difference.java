
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1 + k2;

        int max = 0;
        int[] diff = new int[n];

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
        }

        int[] freq = new int[max + 1];

        for (int d : diff) {
            freq[d]++;
        }

        for (int d = max; d > 0 && k > 0; d--) {
            int count = freq[d];

            if (k >= count) {
                k -= count;
                freq[d - 1] += count;
                freq[d] = 0;
            } else {
                freq[d] -= (int) k;
                freq[d - 1] += (int) k;
                k = 0;
            }
        }

        long sum = 0;

        for (int d = 1; d <= max; d++) {
            sum += (long) d * d * freq[d];
        }

        return sum;
    }
}
