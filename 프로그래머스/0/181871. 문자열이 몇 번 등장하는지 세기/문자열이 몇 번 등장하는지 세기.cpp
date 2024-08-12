#include <string>
#include <vector>

using namespace std;

int solution(string myString, string pat) {
    int answer = 0;
    int idx = 0;
    
    while(myString.find(pat, idx) != string::npos) {
        idx = myString.find(pat, idx) + 1;
        answer++;
    }
    
    return answer;
}