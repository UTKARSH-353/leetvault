class Solution {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int del = n / 20;
        int sum = 0;
        for (int i = del; i < n - del; i++) {
            sum += arr[i]; 
        }    
        return (double) sum / (n - 2 * del);
    }
}
