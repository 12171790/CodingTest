#include <string>
#include <vector>
#include <cmath>

using namespace std;

int solution(int n) {
    int answer = 0;
    vector<int> v;
    
    while(n > 0) {
        v.emplace_back(n % 3);
        n = n / 3;
    }
    
    for (int i = v.size() - 1; i >= 0; i--) {
        answer += pow(3, v.size() - 1 - i) * v[i];
    }
    
    return answer;
}