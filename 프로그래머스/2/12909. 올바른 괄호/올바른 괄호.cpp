#include<string>
#include <vector>
#include <iostream>

using namespace std;

bool solution(string s)
{
    bool answer = true;
    vector<int> v;
    
    for (char c : s) {
        if (c == '(') {
            v.emplace_back(1);
        } else if (c == ')') {
            if (v.size() <= 0) {
                answer = false;
                break;
            } else {
                v.pop_back();
            }
        }
    }
    
    if(answer) {
        answer = v.size() == 0 ? true : false;
    }

    return answer;
}