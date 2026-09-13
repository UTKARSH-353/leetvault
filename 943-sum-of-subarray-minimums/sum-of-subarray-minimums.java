import java.util.*;

class Solution {
    public int sumSubarrayMins(int[] arr) {

        int n = arr.length;
        int mod = 1000000007;

        Stack<Integer> stack = new Stack<>();
        long sum = 0;

        for (int i = 0; i <= n; i++) {

            int current = (i == n) ? 0 : arr[i];

            while (!stack.isEmpty() &&
                   arr[stack.peek()] > current) {

                int mid = stack.pop();

                int left = stack.isEmpty()
                        ? -1
                        : stack.peek();

                int right = i;

                long count =
                        (long) (mid - left) * (right - mid);

                sum = (sum + arr[mid] * count) % mod;
            }

            stack.push(i);
        }

        return (int) sum;
    }
}