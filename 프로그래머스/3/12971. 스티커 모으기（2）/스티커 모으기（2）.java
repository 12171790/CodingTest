class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        int n = sticker.length;
        if (n == 1) return sticker[0];        
        int[] arr = new int[n];
        
        arr[0] = 0;
        arr[1] = sticker[1];
        for (int i = 2; i < n; i++) {
            arr[i] = Math.max(arr[i - 2] + sticker[i], arr[i - 1]);
        }
        
        int temp = arr[n - 1];
        arr = new int[n];
        
        arr[0] = sticker[0];
        arr[1] = arr[0];
        
        for (int i = 2; i < n - 1; i++) {
            arr[i] = Math.max(arr[i - 2] + sticker[i], arr[i - 1]);
        }

        return Math.max(temp, arr[n - 2]);
    }
}