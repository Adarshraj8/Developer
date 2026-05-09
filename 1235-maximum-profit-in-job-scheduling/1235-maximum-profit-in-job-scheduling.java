import java.util.*;

class Solution {

    int n;
    int[][] jobs;
    int dp[];
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        n = startTime.length;

        // Step 1: Combine in  to jobs array
        jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i]; // start
            jobs[i][1] = endTime[i];   // end
            jobs[i][2] = profit[i];    // profit
        }

        // Step 2: Sort by start time
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
         dp = new int[n+1];
        // Step 3: Call recursion
        return solve(0);
    }

    
    private int solve(int i) {

        // Base case
       // if (i == n) return 0;
        //if(dp[i]!=0)return dp[i];
        for(int j=n-1;j>=0;j--){
        // OPTION 1: Skip current job
        int skip = dp[j+ 1];
           
        // OPTION 2: Take current job
        int next = j + 1;

        // Find next non-overlapping job
        while (next < n && jobs[next][0] < jobs[j][1]) {
            next++;
        }

        int take = jobs[j][2] + dp[next];
        dp[j] = Math.max(skip, take);
        }
        // Return maximum
        return dp[0];
    }
}
