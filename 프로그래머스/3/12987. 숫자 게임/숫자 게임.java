import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        PriorityQueue<Integer> pqA = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> maxPqB = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minPqB = new PriorityQueue<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
          pqA.add(A[i]);
          maxPqB.add(B[i]);
          minPqB.add(B[i]);
            
          map.put(B[i], map.getOrDefault(B[i], 0) + 1);
        }

        while(!pqA.isEmpty()) {
          int maxA = pqA.peek();
          int maxB = maxPqB.peek();
            
          if (map.get(maxB) <= 0) {
              maxPqB.poll();
              continue;
          }

          if (maxB > maxA) {
            pqA.poll();
            maxPqB.poll();
            map.put(maxB, map.get(maxB) - 1);
            answer++;
          } else {
            int minB = minPqB.peek();
              
            if (map.get(minB) <= 0) {
                minPqB.poll();
                continue;
            }  
            minPqB.poll();

            pqA.poll();
            map.put(minB, map.get(minB) - 1);
          }
        }
        
        return answer;
    }
}