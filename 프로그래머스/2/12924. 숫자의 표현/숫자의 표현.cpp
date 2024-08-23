#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 0;
    int sum = 0;
    int start = 1;
    
    while(start <= n) {
        sum = 0;
        for (int i = start; i <= n; i++) {
           sum += i;
            
            if (sum >= n) {
                break;
            }
        }
        
        if (sum == n) {
            answer++;
        }
        start++;
    }
    
    return answer;
}