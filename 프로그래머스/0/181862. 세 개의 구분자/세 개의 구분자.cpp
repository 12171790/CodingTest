#include <string>
#include <vector>

using namespace std;

vector<string> solution(string myStr) {
    vector<string> answer;
    string temp = "";
    
    for (int i = 0; i < myStr.length(); i++) {
        char ch = myStr[i];
        
        if (ch == 'a' || ch == 'b' || ch == 'c') {
            if (temp.length() > 0) {
                answer.emplace_back(temp);
                temp = "";
            }
            continue;
        } else {
            temp += ch;
        }
        
        if (i == myStr.length() - 1) {
            if (temp.length() > 0) {
                answer.emplace_back(temp);
                temp = "";
            }
        }
    }
    
    if (answer.size() == 0) {
        answer.emplace_back("EMPTY");
    }
    
    return answer;
}