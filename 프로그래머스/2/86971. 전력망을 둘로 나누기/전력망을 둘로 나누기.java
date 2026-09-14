import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        for (int i = 0; i < wires.length; i++)
        {
            Deque<int[]> queue = new ArrayDeque<>();
            int cnt = 0;
            boolean[] visited = new boolean[wires.length];

            for (int j = 0; j < wires.length; j++)
            {
                if (i != j)
                {
                    queue.offerLast(wires[j]);
                    visited[j] = true;
                    break;
                }
            }

            // i번째 전선 제거
            // 트리 순회하며 개수 세기
            while(!queue.isEmpty())
            {
                int[] temp = queue.pollFirst();
                int start = temp[0];
                int end = temp[1];
                cnt++;

                for (int k = 0; k < wires.length; k++)
                {
                    if (visited[k]) continue;

                    if (k != i && (end == wires[k][0] || end == wires[k][1]))
                    {
                        queue.offerLast(wires[k]);
                        visited[k] = true;
                    }
                    else if (k != i && (start == wires[k][1] || start == wires[k][0]))
                    {
                        queue.offerLast(wires[k]);
                        visited[k] = true;
                    }
                }
            }

            answer = Math.min(Math.abs(2 * cnt + 2 - n), answer);
        }
        
        return answer;
    }
}