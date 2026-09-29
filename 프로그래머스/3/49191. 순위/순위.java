class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        int[][] battle = new int[n + 1][n + 1];
        for (int i = 0; i < results.length; i++)
        {
            battle[results[i][0]][results[i][1]] = 1;
        }

        for (int k = 1; k <= n; k++)
        {
            for (int i = 1; i <= n; i++)
            {
                for (int j = 1; j <= n; j++)
                {
                    if (battle[i][k] == 1 && battle[k][j] == 1)
                    {
                        battle[i][j] = 1;
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++)
        {
            int cnt = 0;
            for (int j = 1; j <= n; j++)
            {
                if (battle[i][j] == 1 || battle[j][i] == 1) cnt++;
            }

            if (cnt == n - 1) answer++;
        }
        
        return answer;
    }
}