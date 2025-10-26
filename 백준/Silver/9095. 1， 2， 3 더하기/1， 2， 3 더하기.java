import java.util.*;
import java.io.*;

public class Main {
    static int[] arr = new int[15];
    
    static void func(int k) {
        arr[k] = arr[k - 1] + arr[k - 2] + arr[k - 3];
    }
    
    public static void main(String[] args) throws IOException {
        // a(n) = a(n - 1) + a(n - 2) + a(n - 3)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            
            for (int i = 4; i <= n; i++) {
                func(i);
            }
            
            System.out.println(arr[n]);
        }
    }
}