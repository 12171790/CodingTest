#include <string>
#include <vector>
#include <cmath>

using namespace std;

vector<int> solution(vector<int> arr) {
    vector<int> answer;
    int length = arr.size();
    int cnt = 0;
    
    while(length > 1) {
        length = length / 2;
        cnt++;
    }
    
    if (arr.size() != pow(2, cnt)) {
        while(arr.size() < pow(2, cnt + 1)) {
            arr.emplace_back(0);
        }
    }
    

    answer = arr;
    
    return answer;
}