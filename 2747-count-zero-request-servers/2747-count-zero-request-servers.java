class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        
        int numQueries = queries.length;
        int result[] = new int[numQueries];

    // 1. Pair each query with its original index so we can fill the result correctly
        int sortedQueries[][]= new int[numQueries][2];

        for(int i=0;i<numQueries;i++){
            sortedQueries[i][0]=queries[i];//query time
            sortedQueries[i][1]=i;//original index
        }

        //sort logs and time by ascending order

        Arrays.sort(logs,(a,b)-> Integer.compare(a[1],b[1]));
        Arrays.sort(sortedQueries,(a,b)->Integer.compare(a[0],b[0]));

        // Map to keep track of active servers and their request counts in the current window
        Map<Integer,Integer> activeServers = new HashMap<>();

       int left=0;
       int right=0;
       int numLogs=logs.length;

       // 3. Process each query using the sliding window

       for(int i=0;i<numQueries;i++){
        int queryTime = sortedQueries[i][0];
        int originalIndex = sortedQueries[i][1];

        int windowStart = queryTime-x;
        int windowEnd = queryTime;

        // Expand the window: Add logs that fall into the current query's window range

        while(right<numLogs&&logs[right][1]<=windowEnd){
            int serverId = logs[right][0];

            activeServers.put(serverId,activeServers.getOrDefault(serverId,0)+1);
            right++;
        }
         // Shrink the window: Remove logs that have fallen out behind the window range
            while (left < numLogs && logs[left][1] < windowStart) {
                int serverId = logs[left][0];
                if (activeServers.containsKey(serverId)) {
                    activeServers.put(serverId, activeServers.get(serverId) - 1);
                    if (activeServers.get(serverId) == 0) {
                        activeServers.remove(serverId);
                    }
                }
                left++;
            }
            
            // The number of unique active servers is the size of our map.
            // The number of silent servers is: Total (n) - Active
            result[originalIndex] = n - activeServers.size();
        }
       return result;
    }
}