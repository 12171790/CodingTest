import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        int[] cpProgresses = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++)
        {
            cpProgresses[i] = progresses[i];
        }
        
        List<Integer> answerList = new ArrayList<>();
        int idx = 0;
        
        while(idx < progresses.length)
        {
            int cnt = 0;
            for (int i = idx; i < cpProgresses.length; i++)
            {
                if (cpProgresses[i] >= 100) continue;
                cpProgresses[i] = cpProgresses[i] + speeds[i];
            }
            
            for (int i = idx; i < cpProgresses.length; i++)
            {
                if (cpProgresses[i] >= 100)
                {
                    cnt++;
                    idx++;
                }
                else
                {
                    break;
                }
            }
                        
            if (cnt > 0)
            {   
                answerList.add(cnt);
            }
        }
        
        answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++)
        {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}