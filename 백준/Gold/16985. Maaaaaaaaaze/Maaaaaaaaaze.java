import java.util.*;
import java.io.*;

public class Main {
  static final int N = 5;
  static int[][][] base = new int[N][N][N]; // 입력 원본 [layer][N][N]
  static int[][][][] rot = new int[N][4][N][N]; // rot[layer][회전][x][y]
  static boolean[] used = new boolean[N];
  static int[] perm = new int[N]; // 층 쌓는 순서
  static int[] rsel = new int[N]; // 각 층 회전 선택
  static int ans = Integer.MAX_VALUE;

  // BFS용
  static final int[] dz = {1, -1, 0, 0, 0, 0};
  static final int[] dx = {0, 0, 1, -1, 0, 0};
  static final int[] dy = {0, 0, 0, 0, 1, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    // 원본 입력 받기
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        st = new StringTokenizer(br.readLine());
        for (int k = 0; k < N; k++) {
          base[i][j][k] = Integer.parseInt(st.nextToken());
        }
      }
    }

    // 각 층의 4가지 회전 경우 미리 생성
    precomputeRotations();

    // 총 순열 탐색
    dfsPerm(0);

    if (ans != Integer.MAX_VALUE) System.out.println(ans);
    else System.out.println(-1);
  }

  static void precomputeRotations() {
    for (int i = 0; i < N; i++) {
      // 회전 안한 상태 저장
      for (int j = 0; j < 5; j++) {
        System.arraycopy(base[i][j], 0, rot[i][0][j], 0, N);
      }

      //  r : 1 ~ 3 회전한 정보 저장
      for (int r = 1; r < 4; r++) {
        for (int x = 0; x < N; x++) {
          for (int y = 0; y < N; y++) {
            rot[i][r][x][y] = rot[i][r - 1][y][N - x - 1];
          }
        }
      }
    }
  }

  static void dfsPerm(int depth) {
    if (ans == 12) return;

    if (depth == N) {
      // 각 layer를 어떻게 쌓을지 정하면 회전 상태를 조합
      dfsRot(0);
      return;
    }

    for (int i = 0; i < N; i++) {
      if (used[i]) continue;
      used[i] = true;
      perm[depth] = i;
      dfsPerm(depth + 1);
      used[i] = false;
    }
  }

  static void dfsRot(int depth) {
    if (depth == N) {
      if (rot[perm[0]][rsel[0]][0][0] == 0) return;
      if (rot[perm[4]][rsel[4]][4][4] == 0) return;
      int temp = bfs();
      if (temp != -1 && temp < ans) ans = temp;
      return;
    }

    for (int i = 0; i < 4; i++) {
      rsel[depth] = i;
      dfsRot(depth + 1);
    }
  }

  static int bfs() {
    Deque<int[]> queue = new ArrayDeque<>();
    int[][][] visited = new int[N][N][N];
    // 시작점
    queue.offerLast(new int[]{0, 0, 0, 0});
    visited[0][0][0] = 1;

    while(!queue.isEmpty()) {
      int[] temp = queue.pollFirst();
      int z = temp[0];
      int x = temp[1];
      int y = temp[2];
      int cnt = temp[3];

      if (cnt > ans) continue;
      if (z == 4 && x == 4 && y == 4) return cnt;

      for (int i = 0; i < 6; i++) {
        int nz = z + dz[i];
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (nz < 0 || nz >= N) continue;
        if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
        if (rot[perm[nz]][rsel[nz]][nx][ny] != 1) continue;
        if (visited[nz][nx][ny] == 1) continue;
        queue.offerLast(new int[]{nz, nx, ny, cnt + 1});
        visited[nz][nx][ny] = 1;
      }
    }

    return -1;
  }
}