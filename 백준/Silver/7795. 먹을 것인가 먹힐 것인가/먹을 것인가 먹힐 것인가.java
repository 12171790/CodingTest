import java.util.*;
import java.io.*;

public class Main {
  public static class Creature implements Comparable<Creature>{
    public String name;
    public int size;

    public Creature(String name, int size) {
      this.name = name;
      this.size = size;
    }

    @Override
    public int compareTo(Creature other) {
      if (this.size != other.size) {
        return this.size - other.size;
      } else {
        return this.name.compareTo(other.name);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    for (int i = 0; i < t; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      ArrayList<Creature> creatures = new ArrayList<>();
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      int[] arrA = new int[n];
      int[] arrB = new int[m];

      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        Creature creature = new Creature("A", Integer.parseInt(st.nextToken()));
        creatures.add(creature);
      }

      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        Creature creature = new Creature("B", Integer.parseInt(st.nextToken()));
        creatures.add(creature);
      }

      Collections.sort(creatures);
      int cnt = 0;
      int answer = 0;

      for (Creature curr : creatures) {
        if (curr.name.equals("B")) {
          cnt++;
        } else if (curr.name.equals("A")) {
          answer += cnt;
        }
      }

      System.out.println(answer);
    }
  }
}