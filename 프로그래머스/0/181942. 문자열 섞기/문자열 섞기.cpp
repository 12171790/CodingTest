#include <string>
#include <vector>

using namespace std;

string solution(string str1, string str2) {
    string answer = "";
    
    for (int i = 0; i < str1.length() + str2.length(); i++) {
        if (i % 2 == 0) {
            answer += str1[i / 2];
        } else {
            answer += str2[i / 2];
        }
    }
    
    return answer;
}