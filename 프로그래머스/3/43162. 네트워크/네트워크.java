import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        int[] visited = new int[n];
            
        
        for (int i = 0; i < computers.length; i++) {
            if (visited[i] != 1) {
                dfs(computers, i, visited);
                answer++;
            }
        }
            
        return answer;
    }
    
    public void dfs(int[][] computers, int i, int[] visited) {
        visited[i] = 1;
        
        for (int j = 0; j < computers.length; j++) {
            if (i != j && computers[i][j] == 1 && visited[j] == 0) {
                dfs(computers, j, visited);
            }
        }
    }
}