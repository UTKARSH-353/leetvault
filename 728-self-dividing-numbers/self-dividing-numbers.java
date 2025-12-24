class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int num = left; num <= right; num++) {
            int temp = num;
            boolean isValid = true;
            while (temp > 0) {
                int digit = temp % 10;
                if (digit == 0 || num % digit != 0) {
                    isValid = false;
                    break;
                }
                temp /= 10;
            }
            if (isValid) {
                res.add(num);
            }
        }
        return res;
    }
}
