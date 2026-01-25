class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>();
        for (String b : banned) {
            bannedSet.add(b.toLowerCase());
        }
        Map<String, Integer> map = new HashMap<>();
        String[] words = paragraph
                .toLowerCase()
                .replaceAll("[^a-z ]", " ")
                .split("\\s+");

        String ans = "";
        int max = 0;
        for (String word : words) {
            if (word.length() == 0 || bannedSet.contains(word)) continue;

            map.put(word, map.getOrDefault(word, 0) + 1);

            if (map.get(word) > max) {
                max = map.get(word);
                ans = word;
            }
        }
        return ans;
    }
}
