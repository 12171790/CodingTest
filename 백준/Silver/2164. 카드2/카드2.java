import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new ArrayDeque<>();
        
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        
        while (queue.size() > 1) {
            queue.poll();
            
            int num = queue.poll();
            queue.add(num);
        }
        
        System.out.println(queue.peek());
    }
}