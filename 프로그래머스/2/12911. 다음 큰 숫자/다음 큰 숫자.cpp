#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 0;
    int temp = n;
    bool check = true;
    int cnt = 0;
    string binary = "";
    
    while(temp > 0) {
        binary += temp % 2 + '0';
        temp = temp / 2;
    }
    
    for (int i = 0; i < binary.length(); i++) {
        if (binary[i] == '1') {
            cnt++;
        }
    }
    
    while(check) {
        n++;
        temp = n;
        string temp_binary = "";
        
        while(temp > 0) {
            temp_binary += temp % 2 + '0';
            temp = temp / 2;
        }
        
        int temp_cnt = 0;
        
        for (int i = 0; i < temp_binary.length(); i++) {
            if (temp_binary[i] == '1') {
                temp_cnt++;
            }
        }
        
        if (cnt == temp_cnt) {
            check = false;
            answer = n;
        }    
    }
    
    return answer;
}