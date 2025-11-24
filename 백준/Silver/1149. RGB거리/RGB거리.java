import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr = new int[1005][3];
    static int[][] cost = new int[1005][3];
    
    static void func(int k) {
        arr[k][0] = Math.min(arr[k - 1][1], arr[k - 1][2]) + cost[k][0];
        arr[k][1] = Math.min(arr[k - 1][0], arr[k - 1][2]) + cost[k][1];
        arr[k][2] = Math.min(arr[k - 1][0], arr[k - 1][1]) + cost[k][2];
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        arr[0][0] = cost[0][0];
        arr[0][1] = cost[0][1];
        arr[0][2] = cost[0][2];
        
        for (int i = 1; i < n; i++) {
            func(i);    
        }
        
        System.out.println(Math.min(arr[n - 1][0], Math.min(arr[n - 1][1], arr[n - 1][2])));
    }
}