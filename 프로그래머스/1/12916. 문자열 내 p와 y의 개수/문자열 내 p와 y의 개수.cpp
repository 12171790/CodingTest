#include <string>
#include <iostream>
using namespace std;

bool solution(string s)
{
    bool answer = true;
    int cntY = 0;
    int cntP = 0;
    
    for (int i = 0; i < s.length(); i++) {
        if (tolower(s[i]) == 'y') {
            cntY++;
        } else if (tolower(s[i]) == 'p') {
            cntP++;
        }
    }
    
    answer = cntY != cntP ? false : true;

    return answer;
}