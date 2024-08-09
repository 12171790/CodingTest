#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(string myString, string pat) {
    string answer = "";
    int idx = 0;
    while(myString.find(pat, idx) != string::npos) {
        idx++;
    }
    
    for (int i = 0; i < idx + pat.length() - 1; i++) {
        answer += myString[i];
    }
    
    return answer;
}