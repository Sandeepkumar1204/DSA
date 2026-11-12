import java.util.*;

class Solution {
    public int minMutation(String startGene, String endGene,
                           String[] bank) {

        Set<String> validGenes = new HashSet<>(
            Arrays.asList(bank)
        );

        if (startGene.equals(endGene)) {
            return 0;
        }

        if (!validGenes.contains(endGene)) {
            return -1;
        }

        char[] genes = {'A', 'C', 'G', 'T'};

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(startGene);
        visited.add(startGene);

        int mutations = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                if (current.equals(endGene)) {
                    return mutations;
                }

                char[] arr = current.toCharArray();

                for (int j = 0; j < arr.length; j++) {
                    char original = arr[j];

                    for (char gene : genes) {
                        if (gene == original) {
                            continue;
                        }

                        arr[j] = gene;
                        String next = new String(arr);

                        if (validGenes.contains(next)
                                && !visited.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }

                    arr[j] = original;
                }
            }

            mutations++;
        }

        return -1;
    }
}