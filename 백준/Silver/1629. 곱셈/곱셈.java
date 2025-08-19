import java.io.*;
import java.util.*;

public class Main {
    public static long func(int a, int b, int c) {
        if (b == 1) {
            return a % c;
        }
        long val = func(a, b / 2, c);
        val = val * val % c;
        
        if (b % 2 == 0) return val;
        else return val * a % c;        
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long answer = 1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        System.out.println(func(a, b, c));
    }
}