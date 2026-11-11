class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth,
                            int need1, int need2) {
        long costA = (long) need1 * cost1
                   + (long) need2 * cost2;
        int min = Math.min(need1, need2);

        long costB = (long) min * costBoth
                   + (long) (need1 - min) * cost1
                   + (long) (need2 - min) * cost2;
        long costC = (long) Math.max(need1, need2) * costBoth;

        return Math.min(costA, Math.min(costB, costC));
    }
}