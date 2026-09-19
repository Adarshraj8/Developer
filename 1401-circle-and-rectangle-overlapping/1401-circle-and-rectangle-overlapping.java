class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
  //closest point on rectangle
     int  closestX = Math.max(x1,Math.min(xCenter,x2));
     int closestY  = Math.max(y1,Math.min(yCenter,y2));
    //diestance squared between center and closest point
     int disX = xCenter-closestX;
     int disY = yCenter-closestY;
     
     int distance_squared = (disX*disX)+(disY*disY);
   //if distance is less than or equal to radius ,they overlap
     return distance_squared<=(radius*radius);
    }
}