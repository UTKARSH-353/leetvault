class Solution {
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        boolean[] isPr = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPr[i] = true;
        }
        for (int i = 2; i * i < n; i++) {
            if (isPr[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPr[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPr[i]) count++;
        }

        return count;
    }
}
