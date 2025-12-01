import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] dp = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        dp[0] = arr[0];
        
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + arr[i]; // 0부터 i까지의 합 저장
        }
        
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            i--;
            j--; // index에 맞게 1 감소
            
            int answer = 0;
            if (i > 0) {
                answer = dp[j] - dp[i - 1];
            } else {
                answer = dp[j];
            }
            
            
            System.out.println(answer);
        }
    }
}