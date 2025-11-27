class Solution {
    
    public int findLUSlength(String[] strs) {
        int n = strs.length;
        int ans = -1;

        for (int i = 0; i < n; i++) {
            boolean uncommon = true;
            
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (isSubsequence(strs[i], strs[j])) {
                    uncommon = false;
                    break;
                }
            }
            
            if (uncommon) {
                ans = Math.max(ans, strs[i].length());
            }
        }
        return ans;
    }

    private boolean isSubsequence(String a, String b) {
        int i = 0, j = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == a.length();
    }
}
