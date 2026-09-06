class Solution {
    public int numDistinct(String s, String t) {
        Integer memo[][] = new Integer[s.length()][t.length()];
        return getCount(s,t,0,0,memo);
    }

    private int getCount(String s,String t,int i,int j,Integer memo[][]){

        if(j==t.length())return 1;
        if(i==s.length()) return 0;
        if(memo[i][j]!=null) return memo[i][j];
        int ways=0;
        if(s.charAt(i)==t.charAt(j))
        ways+=getCount(s,t,i+1,j+1,memo);

       ways+=getCount(s,t,i+1,j,memo);
       memo[i][j]=ways;
       return ways;
    }
}