import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] areaInfo = new int[N][N];
        int[][] flooding = new int[N][N];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int maxHeight = Integer.MIN_VALUE;
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                areaInfo[i][j] = temp;
                
                if (temp > maxHeight) maxHeight = temp;
            }
        }
        
        int answer = Integer.MIN_VALUE;
        int rain = maxHeight;
        
        while (rain-- > 0) {           
            int cnt = 0;
            Deque<int[]> queue = new ArrayDeque<>();
            int[][] visited = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 물에 잠긴 지역이면 1, 아니면 0
                    flooding[i][j] = areaInfo[i][j] <= rain ? 1 : 0;
                }
            }
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (flooding[i][j] == 0 && visited[i][j] == 0) {
                        queue.offerLast(new int[]{i, j});
                        visited[i][j] = 1;
                        cnt++;
                        while (!queue.isEmpty()) {
                            int[] temp = queue.pollFirst();
                            int x = temp[0];
                            int y = temp[1];
                
                            for (int dir = 0; dir < 4; dir++) {
                                int nx = x + dx[dir];
                                int ny = y + dy[dir];
                    
                                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                                if (flooding[nx][ny] == 1) continue;
                                if (visited[nx][ny] == 1) continue;
                                queue.offerLast(new int[]{nx, ny});
                                visited[nx][ny] = 1;
                            }
                        }           
                    }
                }
            }
            
            if (cnt > answer) answer = cnt;
        }
        System.out.println(answer);
    }
}