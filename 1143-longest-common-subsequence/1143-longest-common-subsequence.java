class Solution {
    int memo[][];
    public int longestCommonSubsequence(String text1, String text2) {
        memo=new int[text1.length()][text2.length()];
        for(int arr[]:memo){
            Arrays.fill(arr,-1);
        }
        return solve(text1,text2,0,0);
    }

    public int solve(String s1,String s2,int i,int j){
        if(i==s1.length()||j==s2.length())
        return 0;
         if(memo[i][j]!=-1)
         return memo[i][j];
        if(s1.charAt(i)==s2.charAt(j)){
         memo[i][j]= 1+solve(s1,s2,i+1,j+1);
        }else{
        int skip1 = solve(s1,s2,i+1,j);
        int skip2 = solve(s1,s2,i,j+1);
        memo[i][j]= Math.max(skip1,skip2);
    }
    return memo[i][j];
    }
}