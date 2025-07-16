import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        while(!str.equals(".")) {
            ArrayDeque<Character> stack = new ArrayDeque<>();
            boolean isBalance = true;
            for(char ch : str.toCharArray()) {
                if (ch == '(') {
                    stack.push('(');
                } else if (ch == '[') {
                    stack.push('[');
                } else if (ch == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        isBalance = false;
                        break;
                    }
                } else if (ch == ']') {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        isBalance = false;
                        break;
                    }
                }
            }
            
            if (isBalance && stack.isEmpty()) System.out.println("yes");
            else System.out.println("no");
            
            str = br.readLine();
        }
    }
}