class Solution {
    public String shortestBeautifulSubstring(String s, int k) {

      
      int n = s.length();
      String result="";
      int count=0,left=0;
      for(int right=0;right<n;right++){

        if(s.charAt(right)=='1')
         count++;
         
         while(count==k){

            String candidate =  s.substring(left,right+1);

            if(result.isEmpty()||candidate.length()<result.length()
            ||candidate.length()==result.length()&&candidate.compareTo(result)<0)
            result=candidate;

            if(s.charAt(left)=='1')
            count--;
            left++;
         }
      }
      return result;
    }
}