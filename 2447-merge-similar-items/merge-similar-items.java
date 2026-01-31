class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        int[] freq = new int[1001];
        for (int[] it : items1) freq[it[0]] += it[1];
        for (int[] it : items2) freq[it[0]] += it[1];
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            if (freq[i] != 0) {
                res.add(Arrays.asList(i, freq[i]));
            }
        }
        return res;
    }
}
