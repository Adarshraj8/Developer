class Solution {
    public int minAddToMakeValid(String s) {

      if(s==null || s.isEmpty()) return 0;

      int openNeeded =0;
      int closeNeeded=0;

      for(char c : s.toCharArray()){
         
          if(c=='('){
            closeNeeded++;
          }
          else{
            if(closeNeeded>0)
              closeNeeded--;
              else
               openNeeded++;
          }
      }
        return closeNeeded+openNeeded;
    }
}