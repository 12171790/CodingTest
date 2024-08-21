#include <string>
#include <vector>

using namespace std;

string solution(string s) {
    string answer = "";
    int centerIdx = s.length() / 2;
    
    if (s.length() % 2 == 0) {
        centerIdx -= 1;
        answer += s[centerIdx];
        answer += s[centerIdx + 1];
    } else {
        answer += s[centerIdx];
    }
    
    return answer;
}