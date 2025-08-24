class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

       List<Integer> list = new ArrayList<>();

       if(matrix==null||matrix.length==0)return list; 

       int top=0;
       int bottom=matrix.length-1;
       int left=0;
       int right=matrix[0].length-1;

       while(left<=right&&top<=bottom){
             
             for(int col=top;col<=right;col++){
                list.add(matrix[top][col]);
             }
             top++;

             for(int row=top;row<=bottom;row++){
                list.add(matrix[row][right]);
             }
             right--;
           
           if(top<=bottom){
            for(int col=right;col>=left;col--){
                list.add(matrix[bottom][col]);
             }
             bottom--;
           }
             if(left<=right){
              for(int row=bottom;row>=top;row--){
                list.add(matrix[row][left]);
              }
              left++;
             }
           }

       
       return list;
    }
}