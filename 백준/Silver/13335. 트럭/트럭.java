import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 트럭의 수
        int w = Integer.parseInt(st.nextToken()); // 다리의 길이
        int l = Integer.parseInt(st.nextToken()); // 다리의 최대 하중
        
        int[] weight = new int[n]; // 트럭 무게
        int[] bridge = new int[w]; // 다리에 올라간 트럭 위치와 무게
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }
        
        bridge[0] = weight[0];
        int idx = 1; // 몇번째 트럭이 다리에 올라갈 차례인지
        int time = 1; // 단위시간
        while(idx < n) {
            boolean isPossible = true;
            int weightSum = 0;
                        
            // 트럭 이동
            time++; // 시간 증가
            for (int j = bridge.length - 1; j >= 0; j--) {
                if (bridge[j] != 0) {
                    if (j + 1 == w) {
                        bridge[j] = 0;
                    } else {
                        bridge[j + 1] = bridge[j];
                        bridge[j] = 0;
                    }        
                }
            }
           
            for (int j = 0; j < bridge.length; j++) {
                weightSum += bridge[j];
            }
            weightSum += weight[idx];
            
            // idx번째 트럭을 다리에 올릴 수 없는 경우
            if (weightSum > l) {
                isPossible = false;
            } 
            
            if (isPossible) {
                // 트럭을 다리에 추가로 올릴 수 있는 경우
                bridge[0] = weight[idx++];
            }
        }
        System.out.println(time + w);
    }
}