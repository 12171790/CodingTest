#include <string>
#include <vector>
#include <algorithm>
#include <climits>

using namespace std;

vector<int> solution(vector<int> arr) {
    vector<int> answer;
    int min = INT_MAX;
    
    for (int i = 0; i < arr.size(); i++) {
        if (arr[i] < min) {
            min = arr[i];
        }
    }
    
    arr.erase(remove(arr.begin(), arr.end(), min), arr.end());
    
    if (arr.size() == 0) {
        answer.emplace_back(-1);
    } else {
        answer = arr;   
    }
    

    
    return answer;
}