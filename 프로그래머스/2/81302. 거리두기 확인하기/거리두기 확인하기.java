import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        int[] dx = {-1, 0, 1, 0}; // 북동남서
        int[] dy = {0, 1, 0, -1}; // 북동남서
        Deque<int[]> queue = null;

        for (int num = 0; num < places.length; num++)
        {
            String[] room = places[num]; // 죠르디가 확인 중인 방
            queue = new ArrayDeque<>();
            List<int[]> list = new ArrayList<>();
            boolean check = false;

            // 사람 위치 기록
            for (int i = 0; i < room.length; i++)
            {
                char[] chars = room[i].toCharArray();
                for (int j = 0; j < chars.length; j++)
                {
                    if (chars[j] == 'P')
                    {
                        list.add(new int[]{i, j});
                    }
                }
            }

            for (int i = 0; i < list.size(); i++)
            {
                check = false;
                int[] start = list.get(i);
                queue.offerLast(start);
                int[][] dist = new int[5][5];
                dist[start[0]][start[1]] = -1;

                while (!queue.isEmpty())
                {
                    if (check) break;

                    int[] temp = queue.pollFirst();
                    int x = temp[0];
                    int y = temp[1];
                    
                    if (dist[x][y] == 2) continue;

                    for (int idx = 0; idx < 4; idx++)
                    {
                        int nx = x + dx[idx];
                        int ny = y + dy[idx];

                        if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
                        if (dist[nx][ny] != 0) continue;
                        if (room[nx].charAt(ny) == 'X') continue;
                        if (room[nx].charAt(ny) == 'P')
                        {
                            // 2 맨해튼 거리 내에 사람이 존재할 경우
                            check = true;
                            break;
                        }

                        dist[nx][ny] = dist[x][y] == -1 ? 1 : dist[x][y] + 1;
                        queue.offer(new int[]{nx, ny});
                    }
                }

                if (check) break;
            }

            if (check)
            {
                answer[num] = 0;
            }
            else
            {
                answer[num] = 1;
            }
        }
        
        
        return answer;
    }
}