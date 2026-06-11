class Solution {
    public int assignEdgeWeights(int[][] edges) {
        
		
		int mod = 1000000007;
		
		int n = edges.length+1;
		
	    List<List<Integer>> adj = new ArrayList<>();
	   
	    for(int i=0;i<=n;i++)
		 adj.add(new ArrayList<>());
    
	    for(int []e:edges){
		 
		    adj.get(e[0]).add(e[1]);
			adj.get(e[1]).add(e[0]);
			
		}
		
		Queue<Integer> q = new LinkedList<>();
		
		boolean visited[] = new boolean[n+1];
		
		int depth[] = new int[n+1];
		int maxDepth=0;
		
		q.add(1);
		depth[1]=0;
		visited[1]=true;
		
		while(!q.isEmpty()){

           int node = q.poll();
           maxDepth = Math.max(maxDepth,depth[node]);
            
			  for( int neigh :adj.get(node)){
			  if(!visited[neigh]){
			     visited[neigh]= true;
				  depth[neigh] = depth[node]+1;
				  q.add(neigh);
              }
			  
			   }
			   
          }
		  long ans=1;
		  
		  for(int i=0;i<maxDepth-1;i++){
		    ans =(ans*2)%mod;
			}
			return (int) ans;
}
}