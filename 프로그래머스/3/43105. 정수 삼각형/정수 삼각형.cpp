#include <string>
#include <vector>
#include <climits>

using namespace std;

int solution(vector<vector<int>> triangle) {
       int answer = INT_MIN;
    int maxI = triangle.size() - 1; 
    
    vector<vector<int>> dp;
    
    for (int i = 0; i < triangle.size(); i++) {
        vector<int> temp(triangle[i].size());
        dp.emplace_back(temp);
    }
    
    for (int i = 0; i < dp.size(); i++) {
        for (int j = 0; j < dp[i].size(); j++) {
            if (i == 0 && j == 0) dp[i][j] = triangle[0][0];
            else if (j == 0) dp[i][j] = triangle[i][j] + dp[i - 1][0];
            else if (j == dp[i].size() - 1) dp[i][j] = triangle[i][j] + dp[i - 1][dp[i - 1].size() - 1];
            else dp[i][j] = triangle[i][j] + max(dp[i - 1][j - 1], dp[i - 1][j]);
        }
    }
    
    for (int i = 0; i < triangle[maxI].size(); i++) {
        if (dp[maxI][i] > answer) {
            answer = dp[maxI][i];
        }
    }
    
    return answer;
}