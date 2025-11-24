class Solution {
    public int solution(String arr[]) {
        int n = arr.length / 2 + 1;
        int[][] maxDp = new int[n][n];
        int[][] minDp = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            maxDp[i][i] = Integer.parseInt(arr[i * 2]);
            minDp[i][i] = Integer.parseInt(arr[i * 2]);
        }       
        
        for (int len = 1; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                maxDp[i][j] = Integer.MIN_VALUE;
                minDp[i][j] = Integer.MAX_VALUE;
                
                for (int k = i; k < j; k++) {
                    String operator = arr[k * 2 + 1];
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