#include <string>
#include <vector>
#include <sstream>

using namespace std;

int solution(string binomial) {
    int answer = 0;
    vector<string> temp;
    string str;
    stringstream strStream(binomial);
    
    while(strStream >> str) {
        temp.emplace_back(str);
    }
    
    switch(temp[1][0]) {
        case '+': answer = stoi(temp[0]) + stoi(temp[2]); break;
        case '-': answer = stoi(temp[0]) - stoi(temp[2]); break;
        case '*': answer = stoi(temp[0]) * stoi(temp[2]); break;
    }
    
    return answer;
}