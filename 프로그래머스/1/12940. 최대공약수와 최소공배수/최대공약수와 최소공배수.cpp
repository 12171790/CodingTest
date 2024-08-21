#include <string>
#include <vector>
#include <climits>

using namespace std;

vector<int> solution(int n, int m) {
    vector<int> answer;
    int maxNum = INT_MIN;
    int minNum = INT_MAX;
    
    for (int i = 1; i < (m > n ? m : n); i++) {
        if (n % i == 0 && m % i == 0) {
            maxNum = i;
        }
    }
    
    for (int i = m * n; i >= (m > n ? m : n); i--) {
        if (i % n == 0 && i % m == 0) {
            minNum = i;
        }
    }
    
    answer.emplace_back(maxNum);
    answer.emplace_back(minNum);
    
    return answer;
}