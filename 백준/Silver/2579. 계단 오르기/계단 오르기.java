import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] scores = new int[305];
        int[][] arr = new int[305][3];
        
        for(int i = 1; i < n + 1; i++) {
            scores[i] = Integer.parseInt(br.readLine());            
        }
        
        // 현재 계단에 오려면 전전 계단에서 오거나 전 계단에서 오거나 둘 중 하나
        // arr[n][1], arr[n][2]
        // 전 계단 : arr[n - 1][1], arr[n - 1][2]
        // 전전 계단 : arr[n - 2][1], arr[n - 2][2]
        // arr[n][1] = arr[n - 1][2] + scores[n]
        // arr[n][2] = max(전전 계단) + scores[n]
        
        arr[1][1] = scores[1];
        arr[1][2] = 0;
        arr[2][1] = scores[1] + scores[2];
        arr[2][2] = scores[2];
        
        for (int i = 3; i <= n; i++) {
            arr[i][1] = arr[i - 1][2] + scores[i];
            arr[i][2] = Math.max(arr[i - 2][1], arr[i - 2][2]) + scores[i];
        }
        
        System.out.println(Math.max(arr[n][1], arr[n][2]));
    }
}