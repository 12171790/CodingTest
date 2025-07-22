import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            
            if (num == 0 && !stack.isEmpty()) {
                stack.pop();
            } else {
                stack.push(num);
            }
        }
        
        while(!stack.isEmpty()) {
            answer += stack.pop();
        }
        
        System.out.println(answer);
    }
}