class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int INF = Integer.MAX_VALUE;
        int[] prices = new int[n];
        Arrays.fill(prices, INF);
        prices[src] = 0;

        for (int day = 0; day <= k; day++) {
            int[] temp = prices.clone();

            for (int[] f : flights) {
                int u = f[0], v = f[1], cost = f[2];
                if (prices[u] == INF) continue;
                if (prices[u] + cost < temp[v]) {
                    temp[v] = prices[u] + cost;
                }
            }
            prices = temp;
        }
        return prices[dst] == INF ? -1 : prices[dst];
    }
}