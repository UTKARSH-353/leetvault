import java.util.*;

class Solution {

    public List<String> braceExpansionII(String expression) {
        Set<String> result = parse(expression);
        
        List<String> ans = new ArrayList<>(result);
        Collections.sort(ans);
        
        return ans;
    }

    private Set<String> parse(String s) {

        Set<String> result = new HashSet<>();
        result.add("");

        int i = 0;

        while (i < s.length()) {

            char ch = s.charAt(i);

            if (ch == '{') {

                int start = i;
                int count = 0;

                while (i < s.length()) {
                    if (s.charAt(i) == '{') {
                        count++;
                    } else if (s.charAt(i) == '}') {
                        count--;
                    }

                    if (count == 0) {
                        break;
                    }

                    i++;
                }

                String inside = s.substring(start + 1, i);

                Set<String> group = new HashSet<>();

                int level = 0;
                int prev = 0;

                for (int j = 0; j < inside.length(); j++) {

                    if (inside.charAt(j) == '{') {
                        level++;
                    } else if (inside.charAt(j) == '}') {
                        level--;
                    } else if (inside.charAt(j) == ',' && level == 0) {

                        group.addAll(parse(inside.substring(prev, j)));
                        prev = j + 1;
                    }
                }

                group.addAll(parse(inside.substring(prev)));

                result = combine(result, group);

            } else if (ch == ',') {

                Set<String> right = parse(s.substring(i + 1));

                result.addAll(right);
                break;

            } else {

                Set<String> letter = new HashSet<>();
                letter.add(String.valueOf(ch));

                result = combine(result, letter);
            }

            i++;
        }

        return result;
    }

    private Set<String> combine(Set<String> a, Set<String> b) {

        Set<String> result = new HashSet<>();

        for (String x : a) {
            for (String y : b) {
                result.add(x + y);
            }
        }

        return result;
    }
}