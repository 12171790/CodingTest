#include <string>
#include <vector>
#include <cmath>

using namespace std;

vector<int> solution(int brown, int yellow) {
    vector<int> answer;
    int width = 0;
    int height = 0;
    int tempBrown = 0;
    int tempYellow = 0;
    // 가로 >= 세로
    // 최소 height는 3
    // height 1증가 => brown은 2개 증가, yellow는 기존 yellow / (기존 heigth - 2)만큼 증가
    // width 1증가  => brown은 2개 증가, yellow는 기존 yellow / (기존 width - 2)만큼 증가
    
    // 세로 증가
    for (int i = 3; i <= sqrt(yellow) + 2; i++) {
        int y = i - 2;
        tempBrown  = (i - 2) * 4 + 4;
        tempYellow = (i - 2) * (i - 2);
        // 가로 증가
        for (int j = i; j <= ((brown - ((i - 2) * 2)) / 2); j++) {
            if (tempBrown == brown && tempYellow == yellow) {
                answer.emplace_back(j);
                answer.emplace_back(i);
                return answer;
            }
            tempYellow += tempYellow / (j - 2);
            tempBrown += 2;
        }
    }
    
    
    return answer;
}