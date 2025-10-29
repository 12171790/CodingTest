import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int n = board.length;
        int[] dr = {-1, 0, 1, 0}; // 북 동 남 서
        int[] dc = {0, 1, 0, -1}; // 북 동 남 서
        
        // 해당 칸에서의 방향 기록
        // 1이면 수평 방향, 2이면 수직 방향
        // 해당 칸으로 이동했을 때의 비용 기록
        int[][][] cost = new int[n][n][4];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(cost[i][j], Integer.MAX_VALUE);
            }
        }
        
        Deque<int[]> queue = new ArrayDeque<>();
        
        if (board[0][1] == 0) {
            queue.offerLast(new int[] {0, 1, 1});
            cost[0][1][1] = 100;
        }        
        if (board[1][0] == 0) {
            queue.offerLast(new int[] {1, 0, 2});
            cost[1][0][2] = 100;
        }
        
        while(!queue.isEmpty()) {
            int[] temp = queue.pollFirst();
            int r = temp[0], c = temp[1], direction = temp[2];
            int curCost = cost[r][c][direction];
               
            for (int dir = 0; dir < 4; dir++) {
                if (dir == (direction + 2) % 4) continue; 
                int nr = r + dr[dir], nc = c + dc[dir];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                if (board[nr][nc] == 1) continue;
                
                int newCost = curCost + (direction == dir ? 100 : 600);
                
                if (newCost < cost[nr][nc][dir]) {
                    cost[nr][nc][dir] = newCost;
                    queue.offerLast(new int[] {nr, nc, dir});
                }
            }
        }
        
        answer = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            answer = Math.min(answer, cost[n - 1][n - 1][i]);
        }
        
        return answer;
    }
}