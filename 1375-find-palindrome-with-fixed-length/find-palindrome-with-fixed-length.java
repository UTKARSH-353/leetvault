class Solution {
    public long[] kthPalindrome(int[] queries, int intLength) {
        long[] result = new long[queries.length];
        int halfLength = (intLength + 1) / 2;
        long start = (long) Math.pow(10, halfLength - 1);
        long end = (long) Math.pow(10, halfLength) - 1;
        for (int i = 0; i < queries.length; i++) {
            long firstHalf = start + queries[i] - 1;
            if (firstHalf > end) {
                result[i] = -1;
                continue;
            }
            long palindrome = firstHalf;
            long temp = firstHalf;
            if (intLength % 2 == 1) {
                temp = temp / 10;
            }
            while (temp > 0) {
                palindrome = palindrome * 10 + temp % 10;
                temp = temp / 10;
            }
            result[i] = palindrome;
        }
        return result;
    }
}