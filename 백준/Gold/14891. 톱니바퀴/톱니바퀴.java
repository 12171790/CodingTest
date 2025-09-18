import java.io.*;
import java.util.*;

public class Main {
  static int[][] cogwheels = new int[5][8]; // 톱니바퀴 정보 저장

  static void clockwise(int num) {
    // num번째 톱니바퀴 시계 방향 회전
    int idx = 0;
    int inputNum = cogwheels[num][0];
    do {
      int besideIdx = (idx + 1) % 8;
      int temp = cogwheels[num][besideIdx];
      cogwheels[num][besideIdx] = inputNum;
      inputNum = temp;
      idx++;
    } while(idx < 8);
  }

  static void counterClockwise(int num) {
    // num번째 톱니바퀴 반시계 방향 회전
    int idx = 0;
    int startNum = cogwheels[num][0];
    do {
      int besideIdx = (idx + 1) % 8;
      cogwheels[num][idx] = cogwheels[num][besideIdx];
      idx++;
    } while(idx < 7);

    cogwheels[num][7] = startNum;
  }

  public static void main(String[] args) throws IOException
  {
    // N극은 0, S극은 1
    // 톱니바퀴 번호, 방향 => 1인 경우 시계 방향, -1인 경우 반시계 방향
    // 1번 톱니바퀴 3번째 정수 - 2번 톱니바퀴 7번째 정수
    // 2번 톱니바퀴 3번째 정수 - 3번 톱니바퀴 7번째 정수
    // 3번 톱니바퀴 3번째 정수 - 4번 톱니바퀴 7번째 정수
    // 총 k번 톱니바퀴 회전.
    // 톱니바퀴 번호와 회전 방향이 주어짐.
    // BFS로 회전 수행. 회전하는 톱니바퀴 번호에서 맞닿아있는 톱니와 극을 각각 구하고, 만약 회전하게 되면 QUEUE에 넣고, 그게 아니라면 큐에 넣지 않음.
    // 최종 수행했을 때 각 톱니바퀴의 0번째를 고려하여 점수 계산.
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // 톱니바퀴 초기화
    for (int i = 1; i < 5; i++)
    {
      String str = br.readLine();
      for (int j = 0; j < 8; j++)
      {
        cogwheels[i][j] = Integer.parseInt(str.charAt(j) + "");
      }
    }

    int k = Integer.parseInt(br.readLine());
    for (int i = 0; i < k; i++)
    {
      Deque<int[]> queue = new ArrayDeque<>();
      int[] visited = new int[5];
      StringTokenizer st = new StringTokenizer(br.readLine());
      int num = Integer.parseInt(st.nextToken()); // 톱니바퀴 번호
      int dir = Integer.parseInt(st.nextToken()); // 회전 방향 1이면 시계 방향, -1이면 반시계 방향
      visited[num] = 1;

      queue.offerLast(new int[]{num, dir});
      while (!queue.isEmpty())
      {
        int[] curr = queue.pollFirst();
        int currNum = curr[0], currDir = curr[1];

        // 현재 톱니바퀴 좌우 확인
        // 현재 톱니바퀴 왼쪽에 톱니바퀴가 있는 경우
        if (currNum - 1 >= 1 && visited[currNum - 1] == 0)
        {
          int leftNum = currNum - 1;

          // 두 톱니바퀴의 극이 다른 경우 회전
          if (cogwheels[leftNum][2] != cogwheels[currNum][6])
          {
            int newDir = currDir == 1 ? -1 : 1;
            queue.offerLast(new int[]{leftNum, newDir});
            visited[leftNum] = 1;
          }
        }

        // 현재 톱니바퀴 오른쪽에 톱니바퀴가 있는 경우
        if (currNum + 1 <= 4 && visited[currNum + 1] == 0)
        {
          int rightNum = currNum + 1;

          // 두 톱니바퀴의 극이 다른 경우 회전
          if (cogwheels[rightNum][6] != cogwheels[currNum][2])
          {
            int newDir = currDir == 1 ? -1 : 1;
            queue.offerLast(new int[]{rightNum, newDir});
            visited[rightNum] = 1;
          }
        }

        if (currDir == 1) clockwise(currNum);
        else counterClockwise(currNum);
      }
    }

    int answer = 0;

    for (int i = 1; i < 5; i++) {
      answer += cogwheels[i][0] * (int) (Math.pow(2, i - 1));
    }

    System.out.println(answer);
  }
}