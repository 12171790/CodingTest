#include <string>
#include <vector>

using namespace std;

string solution(vector<int> numLog) {
    string answer = "";
    
    for (int i = 0; i < numLog.size() - 1; i++) {
        int num = numLog[i + 1] - numLog[i];
        if (num == 1) {
            answer += 'w';
        } else if (num == -1) {
            answer += 's';
        } else if (num == 10) {
            answer += 'd';
        } else if (num == -10) {
            answer += 'a';
        }
    }
    
    return answer;
}