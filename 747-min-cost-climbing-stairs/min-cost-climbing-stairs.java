class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int cost1 = cost[0];
        int cost2 = cost[1]; 
            for(int i = 2; i<cost.length; i++){
              int curr = cost[i] + Math.min(cost1, cost2);
               cost1 = cost2;
               cost2 = curr;
        }
        return Math.min(cost1, cost2);
    }
}