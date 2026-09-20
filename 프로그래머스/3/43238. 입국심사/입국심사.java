import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long low = times[0];
        long high = (long) times[times.length - 1] * n;
        long curTime = 0;
        long totalCnt = 0;

        while (low != high)
        {
            curTime = (high + low) / 2;
            totalCnt = 0;
            for (int i = 0; i < times.length; i++)
            {
                totalCnt += curTime / times[i];
            }

            if (totalCnt >= n)
            {
                high = curTime;
            }
            else
            {
                low = curTime + 1;
            }
        }
        
        return high;
    }
}