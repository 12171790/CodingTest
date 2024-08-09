#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<string> solution(string myString) {
    vector<string> answer;
    string temp = "";
      
    for (int i = 0; i < myString.length(); i++) {
        if (myString[i] == 'x') {
            answer.emplace_back(temp);
            temp = "";
        } else {
            temp += myString[i];
        }
        
        if (i == myString.length() - 1 && myString[i] != 'x') {
            answer.emplace_back(temp);
        }
        
    }
    
    answer.erase(remove(answer.begin(), answer.end(), ""), answer.end());
    
    for (int i = 0; i < answer.size() - 1; i++) {
        for (int j = 0; j < answer.size() - i - 1; j++) {
            if (answer[j] > answer[j + 1]) {
                string temp = answer[j];
                answer[j] = answer[j + 1];
                answer[j + 1] = temp;
            }
        }
    }
    
    return answer;
}