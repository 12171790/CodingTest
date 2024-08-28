#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 0;
    int num1 = 0;
    int num2 = 1;
    int fib = 0;
    
    for (int i = 2; i <= n; i++) {
        fib = (num1 + num2) % 1234567;
        int temp = num1;
        num1 = num2;
        num2 = fib;
    }
    
    answer = fib;
    
    return answer;
}