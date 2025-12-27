class Solution {

     Map<String,Boolean> memo;
     Set<Integer> stoneSet;
     int lastStone;
    public boolean canCross(int[] stones) {

       stoneSet = new HashSet<>();
       for(int s : stones){
        stoneSet.add(s);
       } 
       lastStone = stones[stones.length-1];
       memo = new HashMap<>();
       return dfs(0,0);
    
    }

    private boolean dfs(int position,int jump){

       if(position==lastStone)return true;

       String key = position+ "," +jump;
       if(memo.containsKey(key)){
        return memo.get(key);
       }

       for(int nextJump=jump-1;nextJump<=jump+1;nextJump++){
          
          if(nextJump>0){
            int nextPos= nextJump+position;
            if(stoneSet.contains(nextPos)){
                if(dfs(nextPos,nextJump)){
                    memo.put(key,true);
                    return true;
                }
            }
          }
       }
      memo.put(key,false);
      return false;
    }
}