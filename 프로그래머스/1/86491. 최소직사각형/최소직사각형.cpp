#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<int>> sizes) {
    int answer = 0;
    
    for (int i = 0; i < sizes.size(); i++) {
        if (sizes[i][1] > sizes[i][0] ) {
            int temp = sizes[i][0];
            sizes[i][0] = sizes[i][1];
            sizes[i][1] = temp;
        }
    }
    
    for (int i = 0; i < sizes.size() - 1; i++) {
        for (int j = 0; j < sizes.size() - i - 1; j++) {
            if (sizes[j][0] < sizes[j + 1][0]) {
                int temp = sizes[j][0];
                sizes[j][0] = sizes[j + 1][0];
                sizes[j + 1][0] = temp;
            }
            
            if (sizes[j][1] < sizes[j + 1][1]) {
                int temp = sizes[j][1];
                sizes[j][1] = sizes[j + 1][1];
                sizes[j + 1][1] = temp;
            }
        }
    }
    
    answer = sizes[0][0] * sizes[0][1];
    
    return answer;
}