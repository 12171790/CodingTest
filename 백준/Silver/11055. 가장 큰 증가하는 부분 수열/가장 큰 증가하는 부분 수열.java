import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] arr = new int[N];
    int[] dp = new int[N];

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    dp[0] = arr[0];
    for (int i = 1; i < N; i++) {
      int sum = arr[i];
      for (int j = i - 1; j >= 0; j--) {
        if (arr[i] > arr[j]) {
          int temp = arr[i] + dp[j];
          sum = Math.max(sum, temp);
        }
      }
      
      dp[i] = sum;
    }
    
    int max = Integer.MIN_VALUE;
    
    for (int i = 0; i < N; i++) {
      max = Math.max(dp[i], max);
    }
    
    System.out.println(max);
  }
}