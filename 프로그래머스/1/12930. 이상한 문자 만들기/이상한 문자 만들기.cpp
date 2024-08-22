#include <string>
#include <vector>

using namespace std;

string solution(string s) {
    string answer = "";
    int cnt = 0;
    
    for (char c : s) {
        if (c == ' ') {
            cnt = 0;
        } else {
            if (cnt % 2 == 0) {
                c = toupper(c);
            } else {
                c = tolower(c);
            }
            cnt++;
        }
        answer += c;
    }
    
    return answer;
}