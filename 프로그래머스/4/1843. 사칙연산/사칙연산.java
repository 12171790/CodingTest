class Solution {
    public int solution(String arr[]) {
        int n = arr.length / 2 + 1; // 숫자 개수
        int[][] maxDp = new int[n][n]; // i ~ j까지 연산 결과의 최댓값 저장
        int[][] minDp = new int[n][n]; // i ~ j까지 연산 결과의 최솟값 저장
        
        // i ~ i번째까지의 최댓값과 최솟값은 모두 i번째 숫자 자신
        for (int i = 0; i < n; i++) {
            maxDp[i][i] = Integer.parseInt(arr[2 * i]);
            minDp[i][i] = Integer.parseInt(arr[2 * i]);
        }
        
        // 구간 길이 설정
        for (int len = 1; len < n; len++) {
            // 시작점 설정
            for (int i = 0; i < n - len; i++) {
                int j = i + len; // 구간 끝점 설정
                maxDp[i][j] = Integer.MIN_VALUE;
                minDp[i][j] = Integer.MAX_VALUE;
                
                // 구간의 기준점 설정
                for (int k = i; k < j; k++) {
                    String operator = arr[2 * k + 1];
                    int maxLeft = maxDp[i][k];
                    int minLeft = minDp[i][k];
                    int maxRight = maxDp[k + 1][j];
                    int minRight = minDp[k + 1][j];
                    
                    if (operator.equals("+")) {
                        maxDp[i][j] = Math.max(maxDp[i][j], maxLeft + maxRight);
                        minDp[i][j] = Math.min(minDp[i][j], minLeft + minRight);
                    } else if (operator.equals("-")) {
                        maxDp[i][j] = Math.max(maxDp[i][j], maxLeft - minRight);
                        minDp[i][j] = Math.min(minDp[i][j], minLeft - maxRight);
                    }
                }
            }
        }
        
        return maxDp[0][n - 1];
    }
}