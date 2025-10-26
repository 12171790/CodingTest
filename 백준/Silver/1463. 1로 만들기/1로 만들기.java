import java.io.*;
import java.util.*;

public class Main {
    static int[] arr = new int[1000005]; // 최소 연산 횟수를 저장.
    static int x;
    
    public static void func(int k) {
       if (k == 1) {
           arr[k] = 0;
           return;
       }
        
        int divThree = Integer.MAX_VALUE, divTwo = Integer.MAX_VALUE, minusOne = Integer.MAX_VALUE;
        
        if (k % 3 == 0) divThree = arr[k / 3] + 1;
        if (k % 2 == 0) divTwo = arr[k / 2] + 1;
        minusOne = arr[k - 1] + 1;
        
        arr[k] = Math.min(divThree, Math.min(divTwo, minusOne));
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        x = Integer.parseInt(br.readLine());
        
        for (int i = 1; i <= x; i++) {
            func(i);
        }
        
        System.out.println(arr[x]);
    }
}