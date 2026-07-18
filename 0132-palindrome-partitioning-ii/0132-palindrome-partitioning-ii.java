class Solution {
    public int minCut(String s) {
        int n = s.length();
        if (n <= 1) return 0;

        boolean[][] isPalin = new boolean[n][n];
        for (int i = 0; i < n; i++) isPalin[i][i] = true;

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && (len == 2 || isPalin[i+1][j-1])) {
                    isPalin[i][j] = true;
                }
            }
        }

        int[] cuts = new int[n];
        for (int i = 0; i < n; i++) {
            if (isPalin[0][i]) {
                cuts[i] = 0;
            } else {
                cuts[i] = i;
                for (int j = 1; j <= i; j++) {
                    if (isPalin[j][i]) {
                        cuts[i] = Math.min(cuts[i], cuts[j-1] + 1);
                    }
                }
            }
        }

        return cuts[n-1];
    }
}