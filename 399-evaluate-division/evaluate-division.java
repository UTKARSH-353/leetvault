import java.util.*;

class Solution {

   
    private Map<String, Map<String, Double>> graph = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values,
                                 List<List<String>> queries) {

      
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double val = values[i];

            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());

            graph.get(a).put(b, val);
            graph.get(b).put(a, 1.0 / val);
        }

        double[] result = new double[queries.size()];

        // Process queries
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);

            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                result[i] = -1.0;
            } else if (start.equals(end)) {
                result[i] = 1.0;
            } else {
                Set<String> visited = new HashSet<>();
                result[i] = dfs(start, end, 1.0, visited);
            }
        }

        return result;
    }

    private double dfs(String current, String target,
                       double product, Set<String> visited) {

        if (current.equals(target)) {
            return product;
        }

        visited.add(current);

        Map<String, Double> neighbors = graph.get(current);
        for (String next : neighbors.keySet()) {
            if (!visited.contains(next)) {
                double res = dfs(next, target,
                        product * neighbors.get(next), visited);
                if (res != -1.0) {
                    return res;
                }
            }
        }

        return -1.0;
    }
}
