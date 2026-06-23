class Solution {
   public int shortestPath(int n, int[][] edges, String labels, int k) {
    
    // Adjacency list
    List<int[]>[] graph = new List[n];
    for (int i = 0; i < n; i++) 
        graph[i] = new ArrayList<>();
    for (int[] e : edges)
        graph[e[0]].add(new int[]{e[1], e[2]}); // {neighbour, weight}
    
    // dist[node][consecutive] = min cost
    int[][] dist = new int[n][k + 1];
    for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
    
    // PQ: {cost, node, consecutive_count}
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    
    // Start node 0, consecutive = 1 (node 0 ka label count)
    pq.offer(new int[]{0, 0, 1});
    dist[0][1] = 0;
    
    while (!pq.isEmpty()) {
        int[] curr = pq.poll();
        int cost = curr[0], node = curr[1], cons = curr[2];
        
        // Answer mil gaya
        if (node == n - 1) return cost;
        
        // Stale state skip karo
        if (cost > dist[node][cons]) continue;
        
        for (int[] nei : graph[node]) {
            int nextNode = nei[0];
            int nextCost = cost + nei[1];
            
            // Consecutive count calculate karo
            int nextCons;
            if (labels.charAt(nextNode) == labels.charAt(node)) {
                nextCons = cons + 1; // same char → increment
            } else {
                nextCons = 1;        // diff char → reset
            }
            
            // k constraint check
            if (nextCons > k) continue; // ❌ invalid
            
            // Better path mila?
            if (nextCost < dist[nextNode][nextCons]) {
                dist[nextNode][nextCons] = nextCost;
                pq.offer(new int[]{nextCost, nextNode, nextCons});
            }
        }
    }
    
    return -1; // No valid path
}
}