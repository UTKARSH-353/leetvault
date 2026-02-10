class Solution {
    public int fillCups(int[] amount) {
        int count = 0;
        while (true) {
            Arrays.sort(amount);
            if (amount[2] == 0) break;
            amount[2]--;
            if (amount[1] > 0) {
                amount[1]--;
            }
            count++;
        }
        return count;
    }
}
