class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        int n = s.length();
        
        long[] dp = new long[n + 1];
        dp[0] = 0; // 0 characters -> 0 distinct non-empty subsequences
        
        int[] lastOccurrence = new int[26]; // -1 means character abhi tak nahi aaya
        Arrays.fill(lastOccurrence, -1);
        
        for (int i = 1; i <= n; i++) {
            char c = s.charAt(i - 1);
            int charIndex = c - 'a';
            
            // Base formula: purane saare subsequences ke aage current character 
            // add karo (naye bane) + purane jaise the waise hi rakho (skip kiya) + akela current char
            dp[i] = (2 * dp[i - 1] + 1) % MOD;
            
            // Agar ye character pehle bhi aaya tha, toh us baar jo naye subsequences bane the 
            // (dp[lastOccurrence-1] + 1), wahi duplicate ban rahe hain ab -- unko hata do
            if (lastOccurrence[charIndex] != -1) {
                int last = lastOccurrence[charIndex];
                dp[i] = (dp[i] - dp[last - 1] - 1 + MOD) % MOD;
                // +MOD isliye taaki subtraction ke baad negative na ho jaye
            }
            
            lastOccurrence[charIndex] = i; // is character ki last seen position update karo
        }
        
        return (int) dp[n];
    }
}