import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[][] workInfo = new int[N][2];
    int[] dp = new int[N];
    StringTokenizer st;

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      workInfo[i][0] = Integer.parseInt(st.nextToken());
      workInfo[i][1] = Integer.parseInt(st.nextToken());
    }

    dp[0] = workInfo[0][0] <= N ? workInfo[0][1] : 0;
    for (int i = 1; i < N; i++) {
      if (i + workInfo[i][0] > N) continue;
      int sum = workInfo[i][1];

      for (int j = i - 1; j >= 0; j--) {
        if (workInfo[j][0] + j <= i) {
          int temp = dp[j] + workInfo[i][1];
          sum = Math.max(sum, temp);
        }
      }
      dp[i] = sum;
    }

    int max = Integer.MIN_VALUE;
    for (int i = 0; i < N; i++) {
      max = Math.max(max, dp[i]);
    }

    System.out.println(max);
  }
}