class Solution {

    public int minimumThreshold(int n, int[][] edges,
                                int source, int target, int k) {

        if (source == target) return 0;

        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        int maxW = 0;

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];

            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w});

            maxW = Math.max(maxW, w);
        }

        int low = 0;
        int high = maxW;
        int ans = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canReach(graph, n, source, target, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean canReach(List<int[]>[] graph, int n,
                             int source, int target,
                             int k, int threshold) {

        Deque<Integer> dq = new ArrayDeque<>();

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[source] = 0;
        dq.offerFirst(source);

        while (!dq.isEmpty()) {

            int node = dq.pollFirst();

            for (int[] nei : graph[node]) {

                int next = nei[0];
                int weight = nei[1];

                int cost = (weight > threshold) ? 1 : 0;

                if (dist[node] + cost < dist[next]) {

                    dist[next] = dist[node] + cost;

                    if (cost == 0) {
                        dq.offerFirst(next);
                    } else {
                        dq.offerLast(next);
                    }
                }
            }
        }

        return dist[target] <= k;
    }
}