import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] numArr;
    static int[] operators = new int[4];
    static int[] used = new int[4];
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    
    public static void dfs(int depth, int sum) {
        if (depth == n) {
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            if (operators[i] == 0) continue;
            if (operators[i] == used[i]) continue; // 해당 연산자를 모두 사용
            int temp = sum;
            if (i == 0) {
                temp += numArr[depth];
            } else if (i == 1) {
                temp -= numArr[depth];
            } else if (i == 2) {
                temp *= numArr[depth];
            } else if (i == 3) {
                if (temp < 0) {
                    temp = temp * (-1);
                    temp /= numArr[depth];
                    temp = temp * (-1);
                } else {
                    temp /= numArr[depth];
                }
            }
            used[i]++;
            dfs(depth + 1, temp);
            used[i]--;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        numArr = new int[n];
        
        for (int i = 0; i < n; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }
        
        dfs(1, numArr[0]);
        System.out.println(max);
        System.out.println(min);
    }
}