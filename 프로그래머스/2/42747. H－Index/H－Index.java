import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int[] temp = new int[citations.length];
        
        for (int i = 0; i < citations.length; i++) {
            temp[i] = citations[i];
        }
        
        Arrays.sort(temp);
                    
        for (int i = 0; i < citations.length; i++) {
            citations[i] = temp[temp.length - i - 1];
        }
                    
        
        for (int maxCitation = citations[0]; maxCitation >= 0; maxCitation--) {
            int cnt = 0;
            
            for (int j = 0; j < citations.length; j++) {
                if (citations[j] >= maxCitation) {
                    cnt++;
                } else {
                    break;
                }
            }
            
            if (cnt >= maxCitation) {
                answer = maxCitation;
                break;
            }            
        }
        
        return answer;
    }
}