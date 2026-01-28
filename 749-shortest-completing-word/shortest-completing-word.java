class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] required = new int[26];
        for (char ch : licensePlate.toCharArray()) {
            if (Character.isLetter(ch)) {
                ch = Character.toLowerCase(ch);
                required[ch - 'a']++;
            }
        }
        String answer = null;
        for (String word : words) {
            int[] freq = new int[26];
            for (char ch : word.toCharArray()) {
                freq[ch - 'a']++;
            }
            if (isValid(required, freq)) {
                if (answer == null || word.length() < answer.length()) {
                    answer = word;
                }
            }
        }
        return answer;
    }
    private boolean isValid(int[] required, int[] freq) {
        for (int i = 0; i < 26; i++) {
            if (freq[i] < required[i]) {
                return false;
            }
        }
        return true;
    }
}
