import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    while(T-->0) {
      int N = Integer.parseInt(br.readLine());
      long[] arr = new long[N];

      arr[0] = 1;
      if (N > 1) arr[1] = 1;
      if (N > 2) arr[2] = 1;

      for (int i = 3; i < N; i++) {
        arr[i] = arr[i - 2] + arr[i - 3];
      }

      System.out.println(arr[N - 1]);
    }
  }
}