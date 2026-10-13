class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};

        int curRow = 0, curCol = 0;
        int h = park.length;
        int w = park[0].length();
        for (int i = 0; i < h; i++)
        {
            for (int j = 0; j < w; j++)
            {
                if (park[i].charAt(j) == 'S')
                {
                    curRow = i;
                    curCol = j;
                }
            }
        }
        
        for (int i = 0; i < routes.length; i++)
        {
            String[] str = routes[i].split(" ");
            String op = str[0];
            int n = Integer.parseInt(str[1]);
            boolean obstacle = false;
            if (op.equals("E"))
            {
                // 동쪽으로 이동
                // 경계 검사
                if (curCol + n >= w) continue;
                // 장애물 검사
                for (int j = curCol; j <= curCol + n; j++)
                {
                    if (park[curRow].charAt(j) == 'X') obstacle = true;
                }
                if (obstacle) continue;
                curCol = curCol + n;
            }
            else if (op.equals("S"))
            {
                // 남쪽으로 이동
                // 경계 검사
                if (curRow + n >= h) continue;
                // 장애물 검사
                for (int j = curRow; j <= curRow + n; j++)
                {
                    if (park[j].charAt(curCol) == 'X') obstacle = true;
                }
                if (obstacle) continue;
                curRow = curRow + n;
                
            }
            else if (op.equals("W"))
            {
                // 서쪽으로 이동
                // 경계 검사
                if (curCol - n < 0) continue;
                // 장애물 검사
                for (int j = curCol; j >= curCol - n; j--)
                {
                    if (park[curRow].charAt(j) == 'X') obstacle = true;
                }
                if (obstacle) continue;
                curCol = curCol - n;
                
            }
            else if (op.equals("N"))
            {
                // 북쪽으로 이동
                // 경계 검사
                if (curRow - n < 0) continue;
                // 장애물 검사
                for (int j = curRow; j >= curRow - n; j--)
                {
                    if (park[j].charAt(curCol) == 'X') obstacle = true;
                }
                if (obstacle) continue;
                curRow = curRow - n;
            }
        }
        
        answer = new int[]{curRow, curCol};
        
        return answer;
    }
}