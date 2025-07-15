import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int[] numArr = new int[100005];
        int[] posArr = new int[2000005];
        int answer = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
            posArr[numArr[i]] = 1;
        }
        
        int num = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < m; i++) {
            int a = numArr[i];
            if (a > num) continue;
            
            int b = num - numArr[i];
            
            if (posArr[b] == 1 && a != b) {
                answer++;
                posArr[a] = 0;
                posArr[b] = 0;
            }    
        }
        
        System.out.println(answer);
    }
}