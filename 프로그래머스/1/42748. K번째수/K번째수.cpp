#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> answer;
    
    for (int i = 0; i < commands.size(); i++) {
        vector<int> temp;
        
        int start = commands[i][0] - 1;
        int end = commands[i][1];
        
        for (int j = start; j < end; j++) {
            temp.emplace_back(array[j]);
        }
        
        sort(temp.begin(), temp.end());
        
        answer.emplace_back(temp[commands[i][2] - 1]);
    }
    
    return answer;
}