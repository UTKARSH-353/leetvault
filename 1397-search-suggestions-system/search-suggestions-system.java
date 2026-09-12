import java.util.*;

class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        List<String> suggestions = new ArrayList<>();
    }

    TrieNode root = new TrieNode();

    public List<List<String>> suggestedProducts(
            String[] products, String searchWord) {

        Arrays.sort(products);

        for (String product : products) {
            insert(product);
        }

        List<List<String>> result = new ArrayList<>();

        TrieNode current = root;

        for (char ch : searchWord.toCharArray()) {

            int index = ch - 'a';

            if (current != null) {
                current = current.children[index];
            }

            if (current == null) {
                result.add(new ArrayList<>());
            } else {
                result.add(current.suggestions);
            }
        }

        return result;
    }

    private void insert(String word) {

        TrieNode current = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];

            if (current.suggestions.size() < 3) {
                current.suggestions.add(word);
            }
        }
    }
}