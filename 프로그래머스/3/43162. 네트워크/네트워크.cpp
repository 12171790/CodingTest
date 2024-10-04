#include <string>
#include <vector>
#include <stack>

using namespace std;

int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    
    vector<bool> visited(computers.size(), false);
    stack<int> stk;
    
    for (int i = 0; i < computers.size(); i++) {
        
        if (visited[i]) continue;
        
        stk.push(i);
        
        while(!stk.empty()) {
            int k = stk.top();
            stk.pop();

            if (visited[k]) {
                continue;
            }

            visited[k] = true;

            for (int j = 0; j < computers[k].size(); j++) {
                if (computers[k][j] == 1 && j != k && !visited[j]) {
                    stk.push(j);
                }
            }
        }
        answer++;
        
    }    
    
    return answer;
}