import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];

        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minPq = new PriorityQueue<>();

        for (String str : operations) {
          String[] strArr = str.split(" ");
          String order = strArr[0];
          int num = Integer.parseInt(strArr[1]);

          if (order.equals("I")) {
            maxPq.add(num);
            minPq.add(num);
          } else if (order.equals("D")) {
            if (num == -1) {
              if (!minPq.isEmpty()) {
                int temp = minPq.poll();
                maxPq.remove(temp);
              }
            } else if (num == 1) {
              if (!maxPq.isEmpty()) {
                int temp = maxPq.poll();
                minPq.remove(temp);
              }
            }
          }
        }

        int maxValue = 0;
        int minValue = 0;
        // 최대값 추출
        if (!maxPq.isEmpty()) {
          maxValue = maxPq.poll();
        }

        // 최소값 추출
        if (!minPq.isEmpty()) {
          minValue = minPq.poll();
        }

        answer[0] = maxValue;
        answer[1] = minValue;
        return answer;
    }
}