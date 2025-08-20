import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[] arr = new int[10];
    static int[] isUsed = new int[10];
    static StringBuilder sb = new StringBuilder();
    
    public static void func(int k) {
        if (k == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }
        
        for (int i = 1; i <= n; i++) {
            if (isUsed[i] != 1) {
                arr[k] = i;
                isUsed[i] = 1;
                func(k + 1);
                isUsed[i] = 0;
            }
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        func(0);
        System.out.println(sb);
    }
}