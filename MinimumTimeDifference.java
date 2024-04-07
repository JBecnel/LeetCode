// https://leetcode.com/problems/minimum-time-difference/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumTimeDifference {
    public static void main(String[] args) {
        String[] timeStrings = new String[]{"00:00","23:59","01:25", "02:45", "03:15", "18:10"};
        ArrayList<String> times = new ArrayList<>();
        for (String t : timeStrings)  {
            times.add(t);
        }

        System.out.println(new MinimumTimeDifference().findMinDifference(times));
    }
    
    public int findMinDifference(List<String> timePoints) {
        // convert times to minutes
        int[] minutes = new int[timePoints.size()];
        int k = 0;
        int h, m;
        for (String t : timePoints) {
            h = Integer.parseInt(t.substring(0,2));
            m = Integer.parseInt(t.substring(3));
            minutes[k++] = h*60+m; 
        }
        Arrays.sort(minutes);
        
        // compare first to last
        int min = minutes[minutes.length-1] - minutes[0];
        if (min > 12*60)
            min = 24*60 - min;
        
        int diff = 0;
        for (int i = 0; i < minutes.length-1; i++) {
            diff = minutes[i+1]-minutes[i];
            if (diff > 12*60)
                diff = 24*60-min;

            if (diff < min) 
                min = diff;
        }

        return min;
    }
}
