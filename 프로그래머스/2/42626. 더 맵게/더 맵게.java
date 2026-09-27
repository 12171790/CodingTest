import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = -1;
        
       PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int num : scoville)
        {
            pq.offer(num);
        }
        int cnt = 0;
        while(!pq.isEmpty())
        {
            int firstMinNum = pq.poll();

            if (firstMinNum >= K)
            {
                answer = cnt;
                break;
            }

            if (pq.isEmpty()) break;
            int secondMinNum = pq.poll();
            pq.offer(firstMinNum + secondMinNum * 2);
            cnt++;
        }
        
        return answer;
    }
}