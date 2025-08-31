// User function Template for Java

class Solution {
    public long countFriendsPairings(int n) {
    HashMap<Integer,Long> dp = new HashMap<>();
    if(n==1||n==0)
    return 1;
    if(dp.containsKey(n))return dp.get(n);
    
    long result = countFriendsPairings(n-1)+(long)(n-1)*countFriendsPairings(n-2);
     dp.put(n,result);
     return result;
    }
}
