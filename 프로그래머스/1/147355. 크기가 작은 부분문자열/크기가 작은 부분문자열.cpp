#include <string>
#include <vector>

using namespace std;

int solution(string t, string p) {
    int answer = 0;
    long ptol = stol(p);
    vector<int> v;
    
    for (int i = 0; i <= t.size() - p.size(); i++) {
        long temp = stol(t.substr(i, p.size()));
        
        if (temp <= ptol) answer++;
    }
    
    return answer;
}