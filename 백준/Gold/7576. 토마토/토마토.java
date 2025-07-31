import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] box = new int[1005][1005];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        Deque<int[]> queue = new ArrayDeque<>();
        boolean check = true;
        int minDate = 0;
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < m; j++) {
                int condition = Integer.parseInt(st.nextToken());
                box[i][j] = condition;
                
                if (condition == 1) {
                    queue.offerLast(new int[] {i, j, 0});
                }
            }
        }
        
        if (queue.isEmpty()) {
            // 익은 토마토가 1개도 없는 경우
            System.out.println("-1");
        } else {
            while(!queue.isEmpty()) {
                int[] tomato = queue.pollFirst();
                int x = tomato[0], y = tomato[1];
                int date = tomato[2] + 1;
                
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    if (box[nx][ny] == 1 || box[nx][ny] == -1) continue;
                    
                    box[nx][ny] = 1;
                    queue.offerLast(new int[] {nx, ny, date});
                    minDate = date;
                }
            }
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (box[i][j] == 0) {
                        check = false;
                        break;
                    }
                }
                
                if (!check) break;
            }
            
            if (check) {
                System.out.println(minDate);
            } else {
                System.out.println("-1");
            }
        }       
    }
}
