class Solution {
    public String toHex(int num) {
        if (num == 0) return "0";
        long n = num;
        if (n < 0) {
            n = (long)(n + (1L << 32)); 
        }
        char[] map = "0123456789abcdef".toCharArray();
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int digit = (int)(n % 16);
            sb.append(map[digit]);
            n /= 16;
        }
        return sb.reverse().toString();
    }
}
