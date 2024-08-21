#include <iostream>
#include <stdio.h>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> d, int budget) {
    int answer = 0;

    sort(d.begin(), d.end());
    
    while(budget >= d[answer] && answer < d.size()) {
        budget -= d[answer++];
    }
    
    
    return answer;
}