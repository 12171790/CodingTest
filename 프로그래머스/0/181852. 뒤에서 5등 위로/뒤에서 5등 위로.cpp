#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> num_list) {
    vector<int> answer;
    
    for (int i = 0; i < num_list.size() - 1; i++) {
        for (int j = 0; j < num_list.size() - i - 1; j++) {
            if (num_list[j] > num_list[j + 1]) {         
                int temp = num_list[j];
                num_list[j] = num_list[j + 1];
                num_list[j + 1] = temp;
            }
        }
    }
    
    num_list.erase(num_list.begin(), num_list.begin() + 5);
    answer = num_list;
    
    return answer;
}