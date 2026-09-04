import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = Integer.MAX_VALUE;
        int alpExcludeACnt = 0;

        List<Integer> upDownCntList = new ArrayList<>();
        for (char c : name.toCharArray())
        {
            int cnt = 0;
            if (c >= 'O')
            {
                cnt = 'Z' - c + 1;
            }
            else
            {
                cnt = c - 'A';
            }

            if (cnt != 0) alpExcludeACnt++;

            upDownCntList.add(cnt);
        }

        for (int i = 0; i < upDownCntList.size(); i++)
        {
            // 오른쪽으로 i까지 이동 후 왼쪽으로 이동
            int move = 1; // 이동 방향
            int curIdx = 0; // 현재 위치
            int totalCnt = 0; // 총 조이스틱 조작 횟수
            int metAlpExcludeACnt = 0; // A를 제외한 알파벳을 만난 횐수
            boolean[] visited = new boolean[upDownCntList.size()]; // 방문한 위치 표시
            while (metAlpExcludeACnt != alpExcludeACnt)
            {
                if (curIdx == i) move *= -1;
                if (curIdx < 0) curIdx = name.length() - 1;
                if (!visited[curIdx] && upDownCntList.get(curIdx) != 0)
                {
                    metAlpExcludeACnt++;
                    totalCnt += upDownCntList.get(curIdx);
                }
                                
                totalCnt++;
                visited[curIdx] = true;
                curIdx += move;
            }
            
            answer = Math.min(answer, totalCnt > 0 ? totalCnt - 1 : totalCnt);
            
            // 왼쪽으로 i까지 이동 후 오른쪽으로 이동
            move = -1; // 이동 방향
            curIdx = name.length() - 1; // 현재 위치
            totalCnt = 0; // 총 조이스틱 조작 횟수
            metAlpExcludeACnt = 0; // A를 제외한 알파벳을 만난 횐수
            visited = new boolean[upDownCntList.size()]; // 방문한 위치 표시
            
            while (metAlpExcludeACnt != alpExcludeACnt)
            {
                if (curIdx == i) move *= -1;
                if (curIdx >= name.length()) curIdx = 0;
                if (!visited[curIdx] && upDownCntList.get(curIdx) != 0)
                {
                    metAlpExcludeACnt++;
                    totalCnt += upDownCntList.get(curIdx);
                }

                visited[curIdx] = true;
                curIdx += move;
                totalCnt++;
            }

            answer = Math.min(answer, totalCnt);
        }
        
        return answer;
    }
}