#include <string>
#include <vector>

using namespace std;

vector<int> solution(string s) {
    vector<int> answer;
    bool check = false;
    int cnt = 0;
    
    for (int i = 0; i < s.length(); i++) {
        cnt = 0;
        check = false;
        
        for (int j = i - 1; j >= 0; j--) {
            cnt++;
            
            if (s[i] == s[j]) {
                check = true;
                break;
            }
        }
        
        if (check) {
            answer.emplace_back(cnt);
        } else {
            answer.emplace_back(-1);
        }
    }
    
    return answer;
}