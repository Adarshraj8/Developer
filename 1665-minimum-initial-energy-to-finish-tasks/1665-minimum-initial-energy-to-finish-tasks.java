class Solution {
    public int minimumEffort(int[][] tasks) {
     
       Arrays.sort(tasks,(a,b)->(b[1]-b[0])-(a[1]-a[0]));

       	   int hi=0;
		   int low=1;
		   
		   for(int task[]:tasks)
		    hi +=task[1];
			
			int answer = hi;
			
			while(low<=hi){
			int mid = low+(hi-low)/2;
			if(canReach(tasks,mid)){
			  answer=mid;
			  hi=mid-1;
			  }else{
			   low=mid+1;
			   }
			   }
			 return answer;  
    }   
	
	
	 private boolean canReach(int tasks[][],int initialEnergy){
	 
	 int energy = initialEnergy;
	 for(int task[]:tasks){
      int actual = task[0];
      int minimum=task[1];
      
	  if(energy<minimum)return false;
	  
	  energy = energy - actual;
	  
	 
	  }
       	  return true;
}
}