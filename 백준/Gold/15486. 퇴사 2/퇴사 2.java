import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[][] workInfo = new int[N][2];

    // i일 아침에 얻을 수 있는 최대 수익
    int[] dp = new int[N + 1];

    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      workInfo[i][0] = Integer.parseInt(st.nextToken());
      workInfo[i][1] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < N; i++) {
      int t = workInfo[i][0];
      int p = workInfo[i][1];
      // 오늘 쉴 경우 다음 날에 돈을 벌지 못함.
      dp[i + 1] = Math.max(dp[i + 1], dp[i]);

      int ni = i + t;
      // 오늘 일할 경우
      if (ni <= N) {
        dp[ni] = Math.max(dp[ni], dp[i] + p);
      }
    }

    System.out.println(dp[N]);
  }
}