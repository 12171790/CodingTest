import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int f = Integer.parseInt(st.nextToken()); // 총 층 수
    int s = Integer.parseInt(st.nextToken()); // 현재 층
    int g = Integer.parseInt(st.nextToken()); // 목표 층
    int u = Integer.parseInt(st.nextToken()); // u만큼 위 층으로 이동
    int d = Integer.parseInt(st.nextToken()); // d만큼 아래 층으로 이동
    int[] move = new int[f + 1];
    int answer = 0;
    boolean reachGFloor = false;
    Deque<int[]> queue = new ArrayDeque<>();
    queue.offerLast(new int[] {s, 0});
    move[s] = 1;
    
    while(!queue.isEmpty()) {
      int[] temp = queue.pollFirst();
      int floor = temp[0];
      int cnt = temp[1];
      
      if (floor == g) {
        reachGFloor = true;
        answer = cnt;
        break;
      }
      
      // u층 만큼 위로 이동
      boolean upCheck = true;
      int uFloor = floor + u;
      if (uFloor > f || move[uFloor] == 1) upCheck = false;
      if (upCheck) {
        queue.offerLast(new int[] {uFloor, cnt + 1});
        move[uFloor] = 1;
      }
      
      // d층 만큼 아래로 이동
      boolean downCheck = true;
      int dFloor = floor - d;
      if (dFloor < 1 || move[dFloor] == 1) downCheck = false;
      if (downCheck) {
        queue.offerLast(new int[] {dFloor, cnt + 1});
        move[dFloor] = 1;
      }
    }
    
    if (reachGFloor) System.out.println(answer);
    else System.out.println("use the stairs");
  }
}