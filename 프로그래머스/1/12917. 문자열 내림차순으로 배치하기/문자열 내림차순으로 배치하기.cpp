#include <string>
#include <vector>

using namespace std;

string solution(string s) {
    string answer = "";
    
    for (int i = 0; i < s.length() - 1; i++) {
        for (int j = 0; j < s.length() - i - 1; j++) {
            if (s[j] < s[j + 1]) {
                char temp = s[j];
                s[j] = s[j + 1];
                s[j + 1] = temp;
            }
        }
    }
    
    answer = s;
    
    return answer;
}