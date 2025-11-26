class Solution {
    public boolean isHappy(int n) {
        int[] seen = new int[1000];
        int index = 0;
        while (n != 1) {
            for (int i = 0; i < index; i++) {
                if (seen[i] == n) {
                    return false;
                }
            }
            seen[index++] = n;
            n = sumOfSquares(n);
        }
        return true; 
    }
    private int sumOfSquares(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }
}
