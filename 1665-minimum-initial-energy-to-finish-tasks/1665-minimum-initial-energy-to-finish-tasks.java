class Solution {
    public int minimumEffort(int[][] tasks) {
     
       Arrays.sort(tasks,(a,b)->(b[1]-b[0])-(a[1]-a[0]));
            
            int answer=0;
            int required=0;
       	   for(int i=tasks.length-1;i>=0;i--){
            required = Math.max(tasks[i][1],required+tasks[i][0]);
           }
          
           return required;
    }   
	
}
