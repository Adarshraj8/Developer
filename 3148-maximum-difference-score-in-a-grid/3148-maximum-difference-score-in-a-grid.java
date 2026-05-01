import java.util.*;

class Solution {
    public int maxScore(List<List<Integer>> grid) {
        int m = grid.size();
        int n = grid.get(0).size();

        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        int maxScore = Integer.MIN_VALUE;

        for (int i = 0; i < m; i++) {
            int leftMin = Integer.MAX_VALUE;

            for (int j = 0; j < n; j++) {
                int current = grid.get(i).get(j);

                int minPrev = Integer.MAX_VALUE;

                if (i > 0) minPrev = Math.min(minPrev, dp[j]);     // from top
                if (j > 0) minPrev = Math.min(minPrev, leftMin);  // from left

                // ensure at least one move
                if (i > 0 || j > 0) {
                    maxScore = Math.max(maxScore, current - minPrev);
                }

                int currMin = Math.min(current, minPrev);

                dp[j] = currMin;
                leftMin = currMin;
            }
        }

        return maxScore;
    }
}