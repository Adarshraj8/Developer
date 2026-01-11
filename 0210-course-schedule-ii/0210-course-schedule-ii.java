class Solution {
    public int
    [] findOrder(int numCourses, int[][] prerequisites) {
        
       
       int indegree[] = new int[numCourses];

       List<List<Integer>> graph = new ArrayList<>();

       for(int i=0;i<numCourses;i++){
         graph.add(new ArrayList<>());
       }

       for(int p[]: prerequisites){
         int dept = p[0];
         int  free = p[1];
         indegree[dept]++;
         graph.get(free).add(dept);
       }
     Queue<Integer> q = new LinkedList<>();
     for(int i=0;i<numCourses;i++){
         if(indegree[i]==0){
            q.add(i);
         }
     }
     
     int result[] = new int[numCourses];
     int index=0;

     while(!q.isEmpty()){
       int curr = q.poll();
       result[index++]=curr;

       for(int next:graph.get(curr)){
         
         indegree[next]--;
         if(indegree[next]==0){
            q.add(next);
         }
       }
     }
     return index==numCourses?result:new int[0];
    }
}