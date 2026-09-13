import java.util.*;

class Solution {
    public int subarrayBitwiseORs(int[] arr) {

        Set<Integer> result = new HashSet<>();
        Set<Integer> prev = new HashSet<>();

        for (int num : arr) {

            Set<Integer> current = new HashSet<>();

            current.add(num);

            for (int value : prev) {
                current.add(value | num);
            }

            result.addAll(current);

            prev = current;
        }

        return result.size();
    }
}