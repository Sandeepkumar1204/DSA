import java.util.*;

class Solution {
    public double[] calcEquation(
        List<List<String>> equations,
        double[] values,
        List<List<String>> queries
    ) {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double value = values[i];

            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());

            graph.get(a).put(b, value);
            graph.get(b).put(a, 1.0 / value);
        }

        double[] ans = new double[queries.size()];

        
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);

            if (!graph.containsKey(start) ||
                !graph.containsKey(end)) {
                ans[i] = -1.0;
            } else if (start.equals(end)) {
                ans[i] = 1.0;
            } else {
                Set<String> visited = new HashSet<>();
                ans[i] = dfs(graph, start, end, visited);
            }
        }

        return ans;
    }

    private double dfs(
        Map<String, Map<String, Double>> graph,
        String current,
        String target,
        Set<String> visited
    ) {
        if (current.equals(target)) {
            return 1.0;
        }

        visited.add(current);

        for (Map.Entry<String, Double> edge :
             graph.get(current).entrySet()) {

            String next = edge.getKey();
            double weight = edge.getValue();

            if (!visited.contains(next)) {
                double result = dfs(
                    graph, next, target, visited
                );

                if (result != -1.0) {
                    return weight * result;
                }
            }
        }

        return -1.0;
    }
}