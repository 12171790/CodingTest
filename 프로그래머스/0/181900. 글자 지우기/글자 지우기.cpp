#include <string>
#include <vector>
#include <sstream>

using namespace std;

string solution(string my_string, vector<int> indices) {
    string answer = "";
    
    for (int i = 0; i < indices.size(); i++) {
        my_string[indices[i]] = ' ';
    }
    
    string str1;
    stringstream strStream(my_string);
    while(strStream >> str1) {
        answer += str1;
    }
    
    return answer;
}