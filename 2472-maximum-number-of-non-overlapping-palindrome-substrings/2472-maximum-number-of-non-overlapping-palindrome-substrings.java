class Solution {
    int[][] memo;
    String s;
    
    public int maxPalindromes(String str, int k) {
        s = str;
        int n = s.length();
        memo = new int[n][n];
        
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];

            for (int len = k; len <= k + 1; len++) {
                int start = i - len;
                if (start >= 0 && isPalindrome(start, i - 1)) {
                    dp[i] = Math.max(dp[i], dp[start] + 1);
                }
            }
        }
        return dp[n];
    }
    
    private boolean isPalindrome(int i, int j) {
        if (i >= j) return true;
        if (memo[i][j] != 0) return memo[i][j] == 1;
        
        boolean result = s.charAt(i) == s.charAt(j) && isPalindrome(i + 1, j - 1);
        memo[i][j] = result ? 1 : -1;
        return result;
    }
}