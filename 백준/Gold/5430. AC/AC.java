import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < t; i++) {
            String order = br.readLine();
            int n = Integer.parseInt(br.readLine());
            Deque<Integer> deque = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(br.readLine(), "[,]");
            StringBuilder sb = new StringBuilder();
            boolean check = true;
            int dir = 0; // 0 : 앞 1 : 뒤
            
            while (st.hasMoreTokens()) {
                deque.offerLast(Integer.parseInt(st.nextToken().trim()));
            }
            
            for (char ch : order.toCharArray()) {
                if (ch == 'R') {
                    dir = (dir + 1) % 2; // 방향 뒤집기
                } else if (ch == 'D') {
                    if (deque.size() == 0) {
                        sb.append("error");
                        check = false;
                        break;
                    } else {
                        if (dir == 0) {
                            deque.pollFirst();
                        } else if (dir == 1) {
                            deque.pollLast();
                        }
                    }
                }
            }
            
            if (check) {
                sb.append("[");
                
                while (deque.size() > 0) {
                    if (dir == 0) {
                        sb.append(deque.pollFirst() + ",");
                    } else if (dir == 1) {
                        sb.append(deque.pollLast() + ",");
                    }
                }
                if (sb.length() > 1) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                sb.append("]");
            }
            
            System.out.println(sb);
        }
    }
}