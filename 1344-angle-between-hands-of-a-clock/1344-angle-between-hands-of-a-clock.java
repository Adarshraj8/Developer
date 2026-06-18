class Solution {
    public double angleClock(int hour, int minutes) {
        
        double min_Angle = minutes*6;
        double hour_Angle = (hour%12)*30+minutes*0.5;

        double diff = Math.abs(hour_Angle-min_Angle);

        return Math.min(diff,360-diff);
    }
}