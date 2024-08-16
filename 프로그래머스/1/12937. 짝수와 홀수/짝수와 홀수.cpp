#include <string>
#include <vector>

using namespace std;

string solution(int num) {
    string answer = "";
    
    if (abs(num % 2) == 1) {
        answer = "Odd";
    } else {
        answer = "Even";
    }
    
    return answer;
}