#include <string>
#include <vector>
#include <sstream>
#include <algorithm>

using namespace std;

string solution(string s) {
    string answer = "";
    vector<int> v;
    int num = 0;
    stringstream strStream(s);
    while(strStream >> num) {
        v.emplace_back(num);
    }
    
    sort(v.begin(), v.end());
    
    int min = v[0];
    int max = v[v.size() - 1];
    
    answer = to_string(min) + " " + to_string(max);
    
    return answer;
}