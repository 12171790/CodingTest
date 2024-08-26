#include <iostream>
#include<string>
#include <algorithm>
using namespace std;

int solution(string s)
{
    int answer = -1;
    string temp = "";
    
    for (int i = 0; i < s.length(); i++) {
        if (s[i] == temp[temp.length() - 1]) {
            temp.pop_back();
        } else {
            temp += s[i];
        }
    }
    
    answer = temp.length() == 0 ? 1 : 0;

    return answer;
}