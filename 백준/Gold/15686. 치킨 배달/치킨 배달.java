import java.util.*;
import java.io.*;

public class Main {
  static int n;
  static int m;
  static int[][] chicken = new int[15][2];
  static int[][] house = new int[101][2];
  static int[][] map;
  static int[][] pickChicken = new int[15][2];
  static int answer = Integer.MAX_VALUE;
  static int chickenCnt = 0; // 치킨집 개수
  static int houseCnt = 0; // 집 개수

  static int getDistance(int x1, int y1, int x2, int y2)
  {
    return Math.abs(x1 - x2) + Math.abs(y1 - y2);
  }

  static void func(int k, int start)
  {
    if (k == m)
    {
      int sum = 0; // 모든 치킨 거리 합
      // 각 집에서의 치킨 거리 계산
      for (int i = 0; i < houseCnt; i++)
      {
        int x = house[i][0];
        int y = house[i][1];
        int minDist = Integer.MAX_VALUE;

        for (int j = 0; j < m; j++)
        {
          int chickenX = pickChicken[j][0];
          int chickenY = pickChicken[j][1];

          minDist = Math.min(minDist, getDistance(x, y, chickenX, chickenY));
          
        }

        sum += minDist;
      }
      answer = Math.min(answer, sum);
      return;
    }

    for (int i = start + 1; i < chickenCnt; i++)
    {
      // 치킨 집 M곳 선택
      pickChicken[k][0] = chicken[i][0];
      pickChicken[k][1] = chicken[i][1];
      func(k + 1, i);
    }
  }

  public static void main(String[] args) throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    map = new int[n][n];

    for (int i = 0; i < n; i++)
    {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        int info = Integer.parseInt(st.nextToken());
        map[i][j] = info;

        // 집 위치 기록
        if (info == 1)
        {
          house[houseCnt][0] = i;
          house[houseCnt][1] = j;
          houseCnt++;
        }

        // 치킨집 위치 기록
        if (info == 2)
        {
           chicken[chickenCnt][0] = i;
           chicken[chickenCnt][1] = j;
           chickenCnt++;
        }
      }
    }

    func(0, -1);
    System.out.println(answer);
  }


}