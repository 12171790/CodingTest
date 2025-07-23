import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        boolean check = true;
        
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            
            if (stack.isEmpty()) {
                stack.push(cnt++);
                sb.append("+\n");
            }
            
            if (stack.peek() != num) {
                if (num < stack.peek()) {
                    check = false;
                    break;
                } else {
                    while(stack.peek() < num) {
                        stack.push(cnt++);
                        sb.append("+\n");
                    }    
                }
            } 
            if (stack.peek() == num) {
                stack.pop();
                sb.append("-\n");
            }
        }
        
        if (check && stack.isEmpty()) System.out.println(sb);
        else System.out.println("NO");
        
    }
}