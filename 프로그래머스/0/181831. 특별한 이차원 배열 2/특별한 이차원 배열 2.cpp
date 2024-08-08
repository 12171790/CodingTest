#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<int>> arr) {
    int answer = 1;
    bool same = true;
    
    for (int i = 0; i < arr.size(); i++) {
        for (int j = 0; j < arr[i].size(); j++) {
            if (arr[i][j] != arr[j][i]) {
                same = false;
                answer = 0;
                break;
            }
        }
        
        if (!same) {
            break;
        }
    }
    
    return answer;
}