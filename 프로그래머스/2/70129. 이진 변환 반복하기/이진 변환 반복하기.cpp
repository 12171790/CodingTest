#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(string s) {
    vector<int> answer;
    int length = 0;
    int zero_cnt = 0;
    int cnt = 0;
    
    while(s != "1") {
        length = s.length();
        s.erase(remove(s.begin(), s.end(), '0'), s.end());
        
        zero_cnt += length - s.length();
        cnt++;
        
        int no_0_length = s.length();
        string temp = "";
        while(no_0_length > 0) {
            temp += (no_0_length % 2) + '0';
            no_0_length = no_0_length / 2;
        }
        s = temp;
    }
    
    answer.emplace_back(cnt);    
    answer.emplace_back(zero_cnt);
    
    return answer;
}