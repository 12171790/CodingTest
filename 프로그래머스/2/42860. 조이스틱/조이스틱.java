class Solution {
    public int solution(String name) {
            int answer = Integer.MAX_VALUE;
            int[] gapArr = new int[name.length()];
            int cnt = 0;
            // A B C D E F G H I J K L M N(+13) O(-12) P Q R S T U W V X Y Z
            // O부터는 -가 더 빠름.
            for (int i = 0 ; i < name.length(); i++)
            {
                char c = name.charAt(i);
                int gap = 0;
                if (c == 'A') continue;

                if (c >= 'O')
                {
                    gap = ('Z' - c) + 1;
                }
                else
                {
                    gap = (c - 'A');
                }
                cnt++;

                gapArr[i] = gap;
            }
            
            if (cnt == 0) return 0;
            
            for (int i = 0; i < gapArr.length; i++)
            {
                int temp = cnt;
                int moveCnt = -1;
                int idx = 0; // 현재 위치
                int move = 1;
                boolean[] visited = new boolean[gapArr.length];

                // i 지점에서 왼쪽으로 진행
                while (temp > 0)
                {
                    if (idx < 0) idx = gapArr.length - 1;
                    if (idx >= gapArr.length) idx = 0;
                    if (!visited[idx] && gapArr[idx] != 0)
                    {
                        temp--;
                        moveCnt += gapArr[idx];
                        visited[idx] = true;
                    }
                    if (idx == i) move = -1;

                    moveCnt++;
                    idx += move;
                }

                answer = Math.min(answer, moveCnt);

                temp = cnt;
                move = -1;
                idx = 0;
                visited = new boolean[gapArr.length];
                moveCnt = -1;

                // i 지점에서 오른쪽으로 진행
                while(temp > 0)
                {
                    if (idx < 0) idx = gapArr.length - 1;
                    if (idx >= gapArr.length) idx = 0;
                    if (!visited[idx] && gapArr[idx] != 0)
                    {
                        temp--;
                        moveCnt += gapArr[idx];
                        visited[idx] = true;
                    }
                    if (idx == i) move = 1;

                    moveCnt++;
                    idx += move;
                }

                answer = Math.min(answer, moveCnt);
            }
        
        return answer;
    }
}