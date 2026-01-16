class Solution {
    public int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);
        long miss = 1; 
        int added = 0;
        int i = 0;
        while (miss <= target) {
            if (i < coins.length && coins[i] <= miss) {
                miss += coins[i++];
            } else {
                added++;
                miss += miss;
            }
        }
        return added;
    }
}
