class Solution {
    public int minimumThreshold(int n, int[][] edges, int source, int target, int k) {
        
       if (source == target) return 0;

      // n nodes hain → n size ki list banao
List<int[]>[] adj = new List[n];

// Har node ki apni empty list banao
for (int i = 0; i < n; i++) {
    adj[i] = new ArrayList<>();
}

// Edges array se graph mein daalo
for (int[] e : edges) {
    adj[e[0]].add(new int[]{e[1], e[2]}); // u → v, weight
    adj[e[1]].add(new int[]{e[0], e[2]}); // v → u, weight
}

// Saari edge weights ek set mein daalo
TreeSet<Integer> weightSet = new TreeSet<>();
for (int[] e : edges) {
    weightSet.add(e[2]); // sirf weight chahiye
}

// List mein convert karo (index se access karne ke liye)
List<Integer> weights = new ArrayList<>(weightSet);
 weights.add(0, 0); // ← BUS YAHI FIX HAI

        int lo = 0;
int hi = weights.size() - 1;
int answer = -1; // default -1, agar koi path na mile

while (lo <= hi) {
    
    int mid = (lo + hi) / 2;
    int threshold = weights.get(mid); // beech wala threshold try karo
    
    if (canReach(adj, n, source, target, k, threshold)) {
        // Kaam kiya! Yeh ek valid answer hai
        // Ab chhota try karo (minimum chahiye)
        answer = threshold;
        hi = mid - 1;
    } else {
        // Nahi kiya! Bada threshold chahiye
        lo = mid + 1;
    }
}

return answer;

    }


private boolean canReach(List<int[]>[] adj, int n, 
                          int src, int tgt, int k, int threshold) {
    
    // Yahan Dijkstra aayega
    // dist[node][heavyEdges] = minimum cost
//    int dist[][] = new int[n][k+1];
//     for(int [] row:dist){
//     Arrays.fill(row, Integer.MAX_VALUE);
// }

  boolean visited[][]= new boolean[n][k+1];
// dist[src][0]=0;

 Queue<int[]> pq = new LinkedList<>();
pq.offer(new int[]{src,0});
while (!pq.isEmpty()) {
    
    // Sabse sasta state nikalo
    int[] cur = pq.poll();
    // int cost  = cur[0];  // abhi tak ki total cost
    int node  = cur[0];  // kaunsa node hai
    int heavy = cur[1];  // kitni heavy edges use hui
    
    // Target mil gaya? → TRUE return karo
    if (node == tgt) return true;
    
    // Purani/outdated state? → skip karo
    // if (cost > dist[node][heavy]) continue;
    
    // Saare neighbors explore karo
    for (int[] neighbor : adj[node]) {
        int next = neighbor[0]; // agla node
        int w    = neighbor[1]; // edge ka weight
        
        // Threshold se compare karo → light ya heavy?
        boolean isHeavy = (w > threshold);
        int newHeavy = heavy + (isHeavy ? 1 : 0);
        
        // Heavy limit cross? → skip
        if (newHeavy > k) continue;
        
        // Better path mila? → update karo
        // int newCost = cost + w;
        if (visited[next][newHeavy]) continue;
        visited[next][newHeavy]=true;
         pq.offer(new int[]{next,newHeavy});
    }
}

// Target kabhi nahi mila → FALSE
return false;



}
}