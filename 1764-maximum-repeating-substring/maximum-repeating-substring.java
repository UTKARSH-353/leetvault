class Solution {
    public int maxRepeating(String sequence, String word) {
        int n = 0;
        String rep = word;

        while (sequence.contains(rep)) {
            n++;
            rep += word;  
        }
        return n;
    }
}
