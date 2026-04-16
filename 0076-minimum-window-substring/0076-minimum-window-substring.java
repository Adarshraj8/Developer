class Solution {
    public String minWindow(String s, String t) {

       int m = s.length();
       int n = t.length();


       
       if(s.length()==0||t.length()==0){
        return "";
       }
       HashMap<Character,Integer> need = new HashMap<>();
       for(char c:t.toCharArray()){
         need.put(c,need.getOrDefault(c,0)+1);
       }
        
        int left=0;
        int right=0;
        int required=need.size();
        int formed=0;
        
        Map<Character,Integer> window = new HashMap<>();
        int minLen=Integer.MAX_VALUE;
        int start=0;
        while(right<s.length()){
         
           char c = s.charAt(right);
           window.put(c,window.getOrDefault(c,0)+1);

          if(need.containsKey(c)
           &&window.get(c).intValue()==need.get(c).intValue()){
             formed++;
           }

            //try shrinking
            while(left<=right&&formed==required){
                c=s.charAt(left);
               if(right-left+1<minLen){
                minLen=right-left+1;
                start=left;
               }   

               window.put(c,window.get(c)-1);

               if(need.containsKey(c)&&window.get(c)<need.get(c)){
                  formed--;
               }     
               left++; 
             }
            
           right++;
        } 

        return minLen==Integer.MAX_VALUE?"":s.substring(start,start+minLen);
    }
}