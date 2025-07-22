import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Deque<Character> stack = new ArrayDeque<>();
        boolean check = true;
        int num = 1;
        int answer = 0;
        
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            
            if (curr == '(') {
                num *= 2;
                stack.push(curr);
            } else if (curr == '[') {
                num *= 3;
                stack.push(curr);
            } else if (curr == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    check = false;
                    break;
                }
                
                if (str.charAt(i - 1) == '(') answer += num;
                stack.pop();
                num /= 2;
            } else {
                if (stack.isEmpty() || stack.peek() != '[') {
                    check = false;
                    break;
                }
                
                if (str.charAt(i - 1) == '[') answer += num;
                stack.pop();
                num /= 3;
            }
        }
        if (check && stack.isEmpty()) System.out.println(answer);
        else System.out.println(0);
    }
}