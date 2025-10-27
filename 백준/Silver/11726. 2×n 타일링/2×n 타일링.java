import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr = new int[1005][3];
    
    static void func(int k) {
        arr[k][1] = (arr[k - 1][1] + arr[k - 1][2]) % 10007;
        arr[k][2] = (arr[k - 2][1] + arr[k - 2][2]) % 10007;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        arr[1][1] = 1;
        arr[1][2] = 0;
        arr[2][1] = 1;
        arr[2][2] = 1;
        
        // n이 짝수인 경우
        // arr[n][1] = arr[n - 1][1] + arr[n - 1][2]
        // arr[n][2] = arr[n - 2][1] + arr[n - 2][2]
        
        for (int i = 3; i <= n; i++) {
            func(i);
        }
        
        System.out.println((arr[n][1] + arr[n][2]) % 10007);
    }
}