#include <string>
#include <vector>

using namespace std;

string solution(string s) {
    string answer = "";
    bool start = true;
    
    for (int i = 0; i < s.length(); i++) {
        if (i == 0 || (s[i - 1] == ' ' && s[i] != ' ')) {
            if (s[i] >= 'a' && s[i] <= 'z') {
                answer += toupper(s[i]);
            } else {
                answer += s[i];
            }
        } else {
            answer += tolower(s[i]);
        }
        
    }
    
    
    return answer;
}