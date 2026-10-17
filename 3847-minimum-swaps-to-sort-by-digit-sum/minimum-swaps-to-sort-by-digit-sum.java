
import java.util.*;

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int sum = 0;

            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }

            arr[i][0] = sum;
            arr[i][1] = nums[i];
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        Map<Integer, Integer> index = new HashMap<>();

        for (int i = 0; i < n; i++) {
            index.put(nums[i], i);
        }

        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] != arr[i][1]) {
                swaps++;

                int j = index.get(arr[i][1]);

                index.put(nums[i], j);
                index.put(arr[i][1], i);

                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        return swaps;
    }
}
