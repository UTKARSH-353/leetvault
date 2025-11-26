class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int[] result = new int[n];
        int idx = 0;
        for (int x : arr2) {
            for (int i = 0; i < n; i++) {
                if (arr1[i] == x) {
                    result[idx++] = x;
                    arr1[i] = -1; 
                }
            }
        }
        List<Integer> leftover = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr1[i] != -1) {
                leftover.add(arr1[i]);
            }
        }
        Collections.sort(leftover);
        for (int val : leftover) {
            result[idx++] = val;
        }
        return result;
    }
}
