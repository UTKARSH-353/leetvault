class Solution {
    public int longestSubstring(String s, int k) {
        return h(s, 0, s.length(), k);
    }
    private int h(String s, int start, int end, int k) {
        if (end - start < k) return 0;
        int[] freq = new int[26];
        for (int i = start; i < end; i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = start; i < end; i++) {
            if (freq[s.charAt(i) - 'a'] < k) {
                int l = h(s, start, i, k);
                int r = h(s, i + 1, end, k);
                return Math.max(l, r);
            }
        }
        return end - start;
    }
}
