class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i <= n / 2; i++) {
            if (num.charAt(0) == '0' && i > 1) break;
            long num1 = Long.parseLong(num.substring(0, i));
            for (int j = 1; Math.max(i, j) <= n - i - j; j++) {
                if (num.charAt(i) == '0' && j > 1) break;
                long num2 = Long.parseLong(num.substring(i, i + j));
                if (check(num, i + j, num1, num2)) return true;
            }
        }
        return false;
    }
    private boolean check(String num, int start, long num1, long num2) {
        while (start < num.length()) {
            long sum = num1 + num2;
            String sumStr = String.valueOf(sum);
            if (!num.startsWith(sumStr, start)) {
                return false;
            }
            start += sumStr.length();
            num1 = num2;
            num2 = sum;
        }
        return true;
    }
}
