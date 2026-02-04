import java.util.*;
import java.io.*;

public class Main {
  static int answer = Integer.MIN_VALUE;
  static int N, M;
  static int[][] board;
  static int[][] visited;
  static int[] dx = {-1, 0, 1, 0}; // 북동남서
  static int[] dy = {0, 1, 0, -1}; // 북동남서

  static void dfs(int x, int y, int depth, int sum) {
    if (depth == 4) {
      answer = Math.max(answer, sum);
      return;
    }

    for (int dir = 0; dir < 4; dir++) {
      int nx = x + dx[dir];
      int ny = y + dy[dir];
      if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
      if (visited[nx][ny] == 1) continue;

      sum += board[nx][ny];
      visited[nx][ny] = 1;
      dfs(nx, ny, depth + 1, sum);
      sum -= board[nx][ny];
      visited[nx][ny] = 0;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    board = new int[N][M];
    visited = new int[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        visited[i][j] = 1;
        dfs(i, j, 1, board[i][j]);
        visited[i][j] = 0;

        int cnt = 0;
        int[] numList = new int[4];
        int min = Integer.MAX_VALUE;
        int sum = board[i][j];

        for (int dir = 0; dir < 4; dir++) {
          int nx = i + dx[dir];
          int ny = j + dy[dir];

          if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
          numList[dir] = board[nx][ny];
          min = Math.min(min, numList[dir]);
          cnt++;
        }

        if (cnt >= 3) {
          for (int k = 0; k < 4; k++) {
            sum += numList[k];
          }
          if (cnt == 4) sum -= min;

          answer = Math.max(answer, sum);
        }
      }
    }

    System.out.println(answer);
  }
}