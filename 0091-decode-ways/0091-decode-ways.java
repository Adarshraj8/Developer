class Solution {
    public int numDecodings(String s) {
        
     int memo[] = new int[s.length()];  
     Arrays.fill(memo,-1); 
     return findNumOfDecoding(0,s,memo);
    }

  public int findNumOfDecoding(int i,String s,int memo[]){
         int n = s.length();
         if(i==n)
         return 1;
         if(s.charAt(i)=='0')return 0;
        if(memo[i]!=-1)return memo[i];
      int ways = findNumOfDecoding(i+1,s,memo);

         if(i+1<n){
          int two = (s.charAt(i)-'0')*10+(s.charAt(i+1)-'0');
          if(two>=10 && two<=26){
          ways+=findNumOfDecoding(i+2,s,memo);

          }
         }
     memo[i]=ways;
    return ways;
  }

}