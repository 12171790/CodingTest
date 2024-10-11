#include <string>
#include <vector>
#include <set>
#include <cmath>

using namespace std;

int solution(int N, int number) {
    int answer = -1;
    vector<vector<int>> dp;
    
    for (int i = 0; i < 8; i++) {
        vector<int> temp;
        int num = 0;
        for (int j = 0; j < i + 1; j++) {
            num += pow(10, j) * N;
        }
        temp.push_back(num);
                
        if (i == 1) {
            temp.push_back(N + N);
            temp.push_back(N - N);
            temp.push_back(N * N);
            temp.push_back(N / N);
        }
        
        if (i > 1) {
            for (int j = 0; j < i; j++) {
                int k = i - j - 1;
                
                for (int m = 0; m < dp[j].size(); m++) {
                    if (dp[j][m] == 0) continue;

                    for (int n = 0; n < dp[k].size(); n++) {
                        if (dp[k][n] == 0) continue;

                        temp.push_back(dp[j][m] + dp[k][n]);
                        temp.push_back(dp[j][m] - dp[k][n]);
                        temp.push_back(dp[j][m] * dp[k][n]);
                        temp.push_back(dp[j][m] / dp[k][n]);
                    }
                }
            }
        }
        
        for (int j = 0; j < temp.size(); j++) {
            if (number == temp[j]) {
                answer = i + 1;
                return answer;
            }
        }

                
        dp.push_back(temp);
    }    
    
    
    return answer;
}