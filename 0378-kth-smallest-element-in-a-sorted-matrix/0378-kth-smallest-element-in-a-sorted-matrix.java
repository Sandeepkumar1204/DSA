


class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] row : matrix) {
            for (int num : row) {
                pq.offer(num);
            }
        }

        while (k > 1) {
            pq.poll();
            k--;
        }

        return pq.poll();
    }
}
