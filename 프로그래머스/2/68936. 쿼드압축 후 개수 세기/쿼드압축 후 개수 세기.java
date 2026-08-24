import java.util.*;

class Solution {
    public int oneCnt = 0;
    public int zeroCnt = 0;
    
    public void func(int[][] arr, int row, int col, int size)
    {
        boolean check = true;
        int initNum = arr[row][col];
        int half = size / 2;
        for (int i = row; i < row + size; i++)
        {
            for (int j = col; j < col + size; j++)
            {
                if (arr[i][j] != initNum) 
                {
                    check = false;
                    break;
                }
            }
        }
        
        if (check)
        {
            if (initNum == 1) oneCnt++;
            else zeroCnt++;
        }
        else
        {
            func(arr, row, col, half); // 좌상
            func(arr, row, col + half, half); // 우상
            func(arr, row + half, col, half); // 좌하
            func(arr, row + half, col + half, half); // 우하
        }
        
        return;
    }
    
    public int[] solution(int[][] arr) {
        int[] answer = {};
        
        func(arr, 0, 0, arr.length);
        
        answer = new int[]{zeroCnt, oneCnt};
        
        return answer;
    }
}