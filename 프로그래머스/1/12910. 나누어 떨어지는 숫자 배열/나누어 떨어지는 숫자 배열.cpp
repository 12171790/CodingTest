#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> arr, int divisor) {
    vector<int> answer;
    
    for (int i = 0; i < arr.size(); i++) {
        if (arr[i] % divisor == 0) {
            answer.emplace_back(arr[i]);
        }
    }
    
    if (answer.size() == 0) {
        answer.emplace_back(-1);
    } else {
        for (int i = 0; i < answer.size() - 1; i++) {
            for (int j = 0; j < answer.size() - i - 1; j++) {
                if (answer[j] > answer[j + 1]) {
                    int temp = answer[j];
                    answer[j] = answer[j + 1];
                    answer[j + 1] = temp;
                }
            }
        }
    }
    
    return answer;
}