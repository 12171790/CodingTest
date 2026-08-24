import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int totalWeight = 0; // 다리 위의 트럭 무게 합
        int arriveTruck = 0; // 반대편에 도착한 트럭 수
        int bridgeTruck = 0; // 다리 위의 트럭 수
        int idx = 0; // 현재 트럭 순번
        Deque<Integer> queue = new ArrayDeque<>();
        
        // 다리에 빈 값 채워넣기
        for (int i = 0; i < bridge_length; i++)
        {
            queue.offerLast(-1);
        }
        
        while (arriveTruck < truck_weights.length)
        {            
            answer++;                       
            int num = queue.pollFirst();
            if (num != -1)
            {
                totalWeight -= truck_weights[num];
                arriveTruck += 1;
                bridgeTruck -= 1;
            }
            
            // 다리 위의 무게 검사
            if (totalWeight + truck_weights[idx] <= weight)
            {
                // 다리 위의 트럭 수 검사
                if (bridgeTruck < bridge_length)
                {
                    // 다리 위에 트럭 추가
                    queue.offerLast(idx);
                    bridgeTruck += 1;
                    totalWeight += truck_weights[idx];
                    
                    if (idx < truck_weights.length - 1) idx++;
                }
            }
            else
            {
                queue.offerLast(-1);
            }
        }
                
        return answer;
    }
}