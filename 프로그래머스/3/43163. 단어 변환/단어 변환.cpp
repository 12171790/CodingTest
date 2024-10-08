#include <string>
#include <vector>
#include <stack>
#include <climits>

using namespace std;

void findOneDifferentWords(stack<vector<int>>& stk, int changeCount, const vector<string>& words, const string& str) {
    for (int i = 0; i < words.size(); i++) {
        int cnt = 0;
        
        for (int j = 0; j < str.length(); j++) {
            if (str[j] == words[i][j]) cnt++;
        }
        
        if (cnt == str.length() - 1) {
            vector<int> temp;
            temp.emplace_back(i);
            temp.emplace_back(changeCount);
            
            stk.push(temp);
        }
    }
}

int solution(string begin, string target, vector<string> words) {
    vector<bool> visited(words.size(), false);
    stack<vector<int>> stk;
    vector<int> change;
    int answer = INT_MAX;
    
    findOneDifferentWords(stk, 1, words, begin);
    
    while(!stk.empty()) {
        vector<int> curr = stk.top();
        stk.pop();
        
        int idx = curr[0];
        int num = curr[1];
        
        if (visited[idx]) continue;
        
        visited[idx] = true;
        string temp = words[idx];
        
        if (temp == target) {
            change.emplace_back(num);
            continue;
        }
        
        findOneDifferentWords(stk, num + 1, words, temp);
    }
    
    if (change.size() == 0) {
        answer = 0;
    } else {
        for (int i = 0; i < change.size(); i++) {
            if (change[i] < answer) answer = change[i];
        }
    }
    
    return answer;
}