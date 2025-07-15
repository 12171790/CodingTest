import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] stack = new int[10005];
        int pos = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            
            if (order.equals("push")) {
                int k = Integer.parseInt(st.nextToken());
                
                stack[pos++] = k;
            } else if (order.equals("pop")) {
                if (pos == 0) {
                    System.out.println(-1);
                    continue;
                }
                
                System.out.println(stack[--pos]);
            } else if (order.equals("size")) {
                System.out.println(pos);
            } else if (order.equals("empty")) {
                if (pos == 0) System.out.println(1);
                else System.out.println(0);
            } else if (order.equals("top")) {
                if (pos == 0) System.out.println(-1);
                else System.out.println(stack[pos - 1]);
            }
        }        
    }
}