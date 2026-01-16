import java.util.*;

class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Arrays.sort(nums1);
        int[][] nums2Index = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums2Index[i][0] = nums2[i];
            nums2Index[i][1] = i;
        }
        Arrays.sort(nums2Index, (a, b) -> a[0] - b[0]);

        int[] res = new int[n];
        int low = 0, high = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            // Compare from largest nums2
            if (nums1[high] > nums2Index[i][0]) {
                res[nums2Index[i][1]] = nums1[high--];
            } else {
                res[nums2Index[i][1]] = nums1[low++];
            }
        }

        return res;
    }
}
