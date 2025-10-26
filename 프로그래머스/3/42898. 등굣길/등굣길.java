class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] path = new int[n + 1][m + 1];
        int[] dx = {-1, 0}; // 북, 서
        int[] dy = {0, -1}; // 북, 서
        
        path[1][1] = 1;
        
        for (int i = 0; i < puddles.length; i++) {
            path[puddles[i][1]][puddles[i][0]] = -1; // 물 웅덩이 표시
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (path[i][j] == -1) continue; // 물 웅덩이인 경우
                
                for (int dir = 0; dir < 2; dir++) {
                    int nx = i + dx[dir], ny = j + dy[dir];
                    
                    if (nx <= 0 || nx > n || ny <= 0 || ny > m) continue;
                    if (path[nx][ny] == -1) continue; // 물 웅덩이인 경우
                    
                    path[i][j] += (path[nx][ny] % 1000000007);
                }
            }
        } 
        
        answer = path[n][m] % 1000000007;
        
        return answer;
    }
}